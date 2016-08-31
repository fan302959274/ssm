package com.tcz.api.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcz.api.mapper.MemberMapper;
import com.tcz.api.model.po.Member;
import com.tcz.api.service.MemberService;
import com.tcz.api.utils.BeanUtils;
import com.tcz.api.utils.RegexUtils;
import com.tcz.core.rest.ResponseUtil;
import com.tcz.core.rest.ResultEnum;

@Service("memberServiceImpl")
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberMapper memberMapper;

	@Override
	public List<Map<String, Object>> selectYunRecord(Long id) {
		return memberMapper.selectYunRecord(id);
	}

	@Override
	public ResponseUtil<Map<String, Object>> login(String account, String password) {
		ResponseUtil<Map<String, Object>> resp = new ResponseUtil<Map<String, Object>>();
		Member member = new Member();
		try {
			if (RegexUtils.isEmail(account)) {
				member.setEmail(account);
			} else if (RegexUtils.isMobileNO(account)) {
				member.setMobilePhone(account);
			}
			Member m = memberMapper.getMemberByAccount(member);
			if (null == m) {
				resp.setFacade(ResultEnum.ACCOUNT_NO_REGISTER);
				return resp;
			} else if (!DigestUtils.md5Hex(password).equals(m.getPassword())) {
				resp.setFacade(ResultEnum.PASSWORD_ERROR);
				return resp;
			}
			resp.setResult(BeanUtils.beanToMap(m));
		} catch (Exception e) {
			resp.setFacade(ResultEnum.LOGIN_ERROR);
		}

		return resp;
	}

	@Override
	public ResponseUtil<Map<String, Object>> register(String account, String password) {
		ResponseUtil<Map<String, Object>> resp = new ResponseUtil<Map<String, Object>>();
		Member member = new Member();
		try {
			if (RegexUtils.isEmail(account)) {
				member.setEmail(account);
			} else if (RegexUtils.isMobileNO(account)) {
				member.setMobilePhone(account);
			}
			Member m = memberMapper.getMemberByAccount(member);
			if (null != m) {
				resp.setFacade(ResultEnum.ACCOUNT_REGISTERED);
				return resp;
			}
			member.setPassword(DigestUtils.md5Hex(password));// 密码
			member.setIsDeleted(0);// 有效位
			member.setCreateDate(new Date());//创建日期
			member.setModifyDate(new Date());//修改日期
			memberMapper.insertSelective(member);

			resp.setResult(BeanUtils.beanToMap(member));
		} catch (Exception e) {
			resp.setFacade(ResultEnum.REGISTER_ERROR);
		}

		return resp;
	}

}
