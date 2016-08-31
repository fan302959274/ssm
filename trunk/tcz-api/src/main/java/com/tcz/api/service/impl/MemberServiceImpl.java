package com.tcz.api.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcz.api.mapper.MemberMapper;
import com.tcz.api.model.po.Member;
import com.tcz.api.service.MemberService;
import com.tcz.api.utils.RegexUtils;
import com.tcz.api.utils.ResultEnum;

@Service("memberServiceImpl")
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberMapper memberMapper;

	@Override
	public List<Map<String, Object>> selectYunRecord(Long id) {
		return memberMapper.selectYunRecord(id);
	}

	@Override
	public ResultEnum login(String account, String password) {
		Member member = new Member();
		if (RegexUtils.isEmail(account)) {
			member.setEmail(account);
		} else if (RegexUtils.isMobileNO(account)) {
			member.setMobilePhone(account);
		}
		Member m = memberMapper.getMemberByAccount(member);
		if (null == m) {
			return ResultEnum.ACCOUNT_NO_REGISTER;
		} else if (!DigestUtils.md5Hex(password).equals(m.getPassword())) {
			return ResultEnum.PASSWORD_ERROR;
		}
		return ResultEnum.SUCCESS;
	}

	@Override
	public ResultEnum register(String account, String password) {
		Member member = new Member();
		if (RegexUtils.isEmail(account)) {
			member.setEmail(account);
		} else if (RegexUtils.isMobileNO(account)) {
			member.setMobilePhone(account);
		}
		Member m = memberMapper.getMemberByAccount(member);
		if (null != m) {
			return ResultEnum.ACCOUNT_REGISTERED;
		}
		member.setPassword(DigestUtils.md5Hex(password));//密码
		member.setIsDeleted(0);//有效位
		memberMapper.insertSelective(member);
		return ResultEnum.SUCCESS;
	}

}
