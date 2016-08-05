package com.tcz.api.service;

import java.util.List;

import com.tcz.api.model.vo.item.ItemVo;

public interface ItemService {
	
	public List<ItemVo> hotItems();

	public List<ItemVo> soonItems();
	
}
