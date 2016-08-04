package com.tcz.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcz.api.model.vo.HotItem;
import com.tcz.api.service.ItemService;
import com.tcz.core.rest.Message;

/**
 * Controller - 商品
 * 
 * @author candy.tam
 *
 */
@RestController
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	// 正在揭晓
	public void raffleItems(){
		
	}

	// 热门推荐
	@RequestMapping("/hotItems")
	public Message hotItems(){
		List<HotItem> items =  itemService.hotItems();
		return Message.success(items); 
	}
	
	// 即将揭晓
	public void soonItems(){
		
	}
	
	// 新品上架
	public void newItems(){
		
	}
	
}
