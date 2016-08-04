package com.tcz.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	// 正在揭晓
	public Message raffleItems(){
		
		return Message.success(null);
	}

	// 热门推荐
	public void hotItems(){
		
	}
	
	// 即将揭晓
	public void soonItems(){
		
	}
	
	// 新品上架
	public void newItems(){
		
	}
	
}
