package com.tcz.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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

	List<Item> findByIds(@Param(value = "ids")List<Long> ids);
}