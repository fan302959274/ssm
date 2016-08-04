package com.tcz.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcz.api.mapper.ItemMapper;
import com.tcz.api.model.po.Item;
import com.tcz.api.model.vo.HotItem;
import com.tcz.api.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private ItemMapper itemMapper;

	@Override
	public List<HotItem> hotItems() {
		List<Item> items = itemMapper.hotItems();
		List<HotItem> hotItems = new ArrayList<>();
		for (int i = 0; i < items.size(); i++) {
			HotItem hotItem = new HotItem();
			BeanUtils.copyProperties(items.get(i), hotItem);
			hotItems.add(hotItem);
		}
		return hotItems;
	}

}
