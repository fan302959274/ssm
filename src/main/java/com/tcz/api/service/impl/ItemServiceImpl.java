package com.tcz.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcz.api.mapper.ItemMapper;
import com.tcz.api.model.po.Item;
import com.tcz.api.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private ItemMapper itemMapper;

	@Override
	public List<Item> hotItems() {
		return itemMapper.hotItems();
	}

}
