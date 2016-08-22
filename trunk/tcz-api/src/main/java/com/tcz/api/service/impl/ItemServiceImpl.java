package com.tcz.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcz.api.mapper.ItemMapper;
import com.tcz.api.model.po.Item;
import com.tcz.api.model.vo.item.ItemVo;
import com.tcz.api.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private ItemMapper itemMapper;

	@Override
	public List<ItemVo> hotItems() {
		List<Item> items = itemMapper.hotItems();
		List<ItemVo> hotItems = new ArrayList<>();
		for (int i = 0; i < items.size(); i++) {
			ItemVo hotItem = new ItemVo();
			BeanUtils.copyProperties(items.get(i), hotItem);
			hotItems.add(hotItem);
		}
		return hotItems;
	}

	@Override
	public List<ItemVo> soonItems() {
		List<Item> items = itemMapper.soonItems();
		List<ItemVo> hotItems = new ArrayList<>();
		for (int i = 0; i < items.size(); i++) {
			ItemVo soonItem = new ItemVo();
			BeanUtils.copyProperties(items.get(i), soonItem);
			hotItems.add(soonItem);
		}
		return hotItems;
	}

	@Override
	public List<ItemVo> newItems() {
		List<Item> items = itemMapper.newItems();
		List<ItemVo> hotItems = new ArrayList<>();
		for (int i = 0; i < items.size(); i++) {
			ItemVo newItem = new ItemVo();
			BeanUtils.copyProperties(items.get(i), newItem);
			hotItems.add(newItem);
		}
		return hotItems;
	}

	@Override
	public Item findById(Long id) {
		return itemMapper.selectByPrimaryKey(id);
	}

}
