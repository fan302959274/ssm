package com.tcz.api.service;

import java.util.List;

import com.tcz.api.model.po.Item;
import com.tcz.api.model.vo.item.ItemVo;

public interface ItemService {
	
	public List<ItemVo> hotItems();

	public List<ItemVo> soonItems();
	
	public List<ItemVo> newItems();
	
	public Item findById(Long id);
	
	public Item findByGoodsId(String goodsId);
	
	public List<Item> findByIds(List<Long> ids);
	
}
