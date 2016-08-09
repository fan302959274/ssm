package com.tcz.api.mapper;

import com.tcz.api.model.po.AdPosition;

public interface AdPositionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AdPosition record);

    int insertSelective(AdPosition record);

    AdPosition selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AdPosition record);

    int updateByPrimaryKey(AdPosition record);
}