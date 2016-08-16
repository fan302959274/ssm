package com.tcz.api.mapper;

import java.util.List;
import java.util.Map;

import com.tcz.api.model.po.Member;

public interface MemberMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Member record);

    int insertSelective(Member record);

    Member selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);
    
    List<Map<String, Object>> selectYunRecord(Long id);
}