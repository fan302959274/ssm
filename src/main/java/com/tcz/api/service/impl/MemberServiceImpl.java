package com.tcz.api.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.Md5Crypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcz.api.mapper.MemberMapper;
import com.tcz.api.model.po.Member;
import com.tcz.api.service.MemberService;
import com.tcz.api.utils.RegexUtils;

@Service("memberServiceImpl")
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberMapper memberMapper;

	@Override
	public List<Map<String, Object>> selectYunRecord(Long id) {
		return memberMapper.selectYunRecord(id);
	}

	@Override
	public Boolean login(String account, String password) {
		Member member = new Member();
		if (RegexUtils.isEmail(account)) {
			member.setEmail(account);
		} else if (RegexUtils.isMobileNO(account)) {
			member.setMobilePhone(account);
		}
		Member m = memberMapper.getMemberByAccount(member);
		if (null == m) {
			return false;
		} else if (!DigestUtils.md5Hex(password).equals(m.getPassword())) {
			return false;
		}
		return true;
	}

}
