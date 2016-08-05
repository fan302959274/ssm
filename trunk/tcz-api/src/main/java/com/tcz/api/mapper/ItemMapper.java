package com.tcz.api.mapper;

import java.util.List;

import com.tcz.api.model.po.Item;

public interface ItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Item record);

    int insertSelective(Item record);

    Item selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKeyWithBLOBs(Item record);

    int updateByPrimaryKey(Item record);
    
    List<Item> hotItems();

	List<Item> soonItems();

	List<Item> newItems();
}