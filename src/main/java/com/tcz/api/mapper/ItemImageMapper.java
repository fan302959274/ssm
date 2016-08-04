package com.tcz.api.mapper;

import com.tcz.api.model.po.ItemImage;

public interface ItemImageMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ItemImage record);

    int insertSelective(ItemImage record);

    ItemImage selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ItemImage record);

    int updateByPrimaryKey(ItemImage record);
}