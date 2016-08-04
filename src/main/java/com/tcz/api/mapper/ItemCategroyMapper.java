package com.tcz.api.mapper;

import com.tcz.api.model.ItemCategroy;

public interface ItemCategroyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ItemCategroy record);

    int insertSelective(ItemCategroy record);

    ItemCategroy selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ItemCategroy record);

    int updateByPrimaryKey(ItemCategroy record);
}