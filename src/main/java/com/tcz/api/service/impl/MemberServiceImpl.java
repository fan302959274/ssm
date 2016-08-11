package com.tcz.api.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcz.api.mapper.MemberMapper;
import com.tcz.api.service.MemberService;

@Service("memberServiceImpl")
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberMapper memberMapper;

	@Override
	public List<Map<String, Object>> selectYunRecord(Long id) {
		return memberMapper.selectYunRecord(id);
	}

	
}
