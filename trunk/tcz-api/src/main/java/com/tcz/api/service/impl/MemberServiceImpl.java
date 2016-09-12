package com.tcz.api.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.assertj.core.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcz.api.mapper.MemberMapper;
import com.tcz.api.model.enums.ResultEnum;
import com.tcz.api.model.po.Member;
import com.tcz.api.service.CaptchaService;
import com.tcz.api.service.MemberService;
import com.tcz.api.utils.BeanUtils;
import com.tcz.api.utils.RegexUtils;
import com.tcz.api.utils.ResponseUtil;

@Service("memberServiceImpl")
public class MemberServiceImpl implements MemberService {
	private Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	MemberMapper memberMapper;

	@Autowired
	CaptchaService captchaService;

	@Override
	public ResponseUtil<List<Map<String, Object>>> selectYunRecord(Long id) {
		ResponseUtil<List<Map<String, Object>>> resp = new ResponseUtil<List<Map<String, Object>>>();
		try {
			List<Map<String, Object>> yunRecordList = memberMapper
					.selectYunRecord(id);
			if (null != yunRecordList && yunRecordList.size() > 0) {
				resp.setResult(yunRecordList);
			}
		} catch (Exception e) {
			log.info("获取云购记录异常" + e.getMessage());
			resp.setFacade(ResultEnum.ERROR);
		}
		return resp;
	}

	/** 帐号未不存在、验证码错误、登录密码错误、帐号已被冻结、此账号未激活、密码被系统锁定、失败次数超限，被冻结5分钟、失败次数超限，IP被冻结 */
	@Override
	public ResponseUtil<Map<String, Object>> login(String account,
			String password, String captcha, String captchaId) {
		ResponseUtil<Map<String, Object>> resp = new ResponseUtil<Map<String, Object>>();
		Member member = new Member();
		try {
			if (RegexUtils.isEmail(account)) {
				member.setEmail(account);
			} else if (RegexUtils.isMobileNO(account)) {
				member.setMobilePhone(account);
			} else {
				// 输入帐号有误
				resp.setFacade(ResultEnum.ACCOUNT_ERROR);
				return resp;
			}

			Member m = memberMapper.getMemberByAccount(member);
			// 帐号未注册
			if (null == m) {
				resp.setFacade(ResultEnum.ACCOUNT_NO_REGISTER);
				return resp;
			}
			boolean captchaValidate = true;
			// 验证码输入有误
			if (null != captcha && !"".equals(captcha)) {
				if (!captchaService.isValid(captchaId, captcha)) {
					captchaValidate = false;
					resp.setFacade(ResultEnum.VALIDATECODE_ERROR);
					return resp;
				}
			}
			// 是否被锁
			if (0 != m.getIsLocked()) {
				resp.setFacade(ResultEnum.PASSWORD_LOCKED);
				return resp;
			}
			// 是否激活
			if (1 != m.getIsEnabled()) {
				resp.setFacade(ResultEnum.ACCOUNT_NO_ENABLED);
				return resp;
			}
			// 验证码错误,密码被锁5分钟
			if (m.getLoginFailureCount() >= 3
					&& null != m.getLoginDate()
					&& (new Date().getTime() - m.getLoginDate().getTime()) < 5 * 60 * 1000) {
				if (null != captcha && !"".equals(captcha)) {
					if (!captchaValidate) {
						resp.setFacade(ResultEnum.VALIDATECODE_ERROR);
						return resp;
					}
				} else {
					// 错误三次锁5分钟
					resp.setFacade(ResultEnum.PASSWORD_LOCKED_FIVEMIN);
					return resp;
				}
			}
			// 密码错误(5次直接锁住)
			if (!DigestUtils.md5Hex(password).equals(m.getPassword())) {
				// 更新登录错误次数
				Integer loginFailureCount = (null == m.getLoginFailureCount() ? 0
						: m.getLoginFailureCount());
				loginFailureCount += 1;
				Member record = new Member();
				record.setId(m.getId());
				record.setLoginFailureCount(loginFailureCount);
				record.setLoginDate(new Date());
				if (loginFailureCount >= 5) {
					record.setLockedDate(new Date());// 被锁日期
					record.setIsLocked(1);// 错误5次直接锁住
				}
				memberMapper.updateByPrimaryKeySelective(record);

				resp.setFacade(ResultEnum.PASSWORD_ERROR);
				return resp;
			}
			// 登录成功清空登录失败次数
			Member record = new Member();
			record.setId(m.getId());
			record.setLoginFailureCount(0);
			record.setLoginDate(new Date());
			memberMapper.updateByPrimaryKeySelective(record);

			resp.setResult(BeanUtils.beanToMap(m));
		} catch (Exception e) {
			log.info("登录异常" + e.getMessage());
			resp.setFacade(ResultEnum.LOGIN_ERROR);
		}

		return resp;
	}

	@Override
	public ResponseUtil<Map<String, Object>> register(String account,
			String password) {
		ResponseUtil<Map<String, Object>> resp = new ResponseUtil<Map<String, Object>>();
		Member member = new Member();
		try {
			if (RegexUtils.isEmail(account)) {
				member.setEmail(account);
			} else if (RegexUtils.isMobileNO(account)) {
				member.setMobilePhone(account);
			} else {
				member.setMobilePhone(account);// 默认是手机号(排除后端出现查询出多个结果集)
			}
			Member m = memberMapper.getMemberByAccount(member);
			if (null != m) {
				resp.setFacade(ResultEnum.ACCOUNT_REGISTERED);
				return resp;
			}
			member.setPassword(DigestUtils.md5Hex(password));// 密码
			member.setIsEnabled(1);// 是否激活
			member.setIsLocked(0);// 是否被锁
			member.setLoginFailureCount(0);// 登录失败次数
			member.setIsDeleted(0);// 有效位
			member.setCreateDate(new Date());// 创建日期
			member.setModifyDate(new Date());// 修改日期
			memberMapper.insertSelective(member);

			resp.setResult(BeanUtils.beanToMap(member));
		} catch (Exception e) {
			log.info("注册异常" + e.getMessage());
			resp.setFacade(ResultEnum.REGISTER_ERROR);
		}

		return resp;
	}

	@Override
	public ResponseUtil<List<Map<String, Object>>> productHaving(Long id) {
		ResponseUtil<List<Map<String, Object>>> resp = new ResponseUtil<List<Map<String, Object>>>();
		try {
			List<Map<String, Object>> yunRecordList = memberMapper
					.productHaving(id);
			if (null != yunRecordList && yunRecordList.size() > 0) {
				resp.setResult(yunRecordList);
			}
		} catch (Exception e) {
			log.info("获取我的商品异常" + e.getMessage());
			resp.setFacade(ResultEnum.ERROR);
		}
		return resp;
	}

}
