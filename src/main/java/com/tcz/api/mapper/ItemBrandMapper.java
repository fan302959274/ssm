package com.tcz.api.mapper;

import com.tcz.api.model.po.ItemBrand;

public interface ItemBrandMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ItemBrand record);

    int insertSelective(ItemBrand record);

    ItemBrand selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ItemBrand record);

    int updateByPrimaryKey(ItemBrand record);
}