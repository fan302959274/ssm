package com.tcz.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcz.api.model.vo.item.ItemVo;
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
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ItemService itemService;
	
	// 正在揭晓
	public void raffleItems(){
		
	}

	// 热门推荐
	@RequestMapping("/hotItems")
	public Message hotItems(){
		List<ItemVo> items = null;
		try {
			items =  itemService.hotItems();
		} catch (Exception e) {
			log.error(e.getMessage() , e);
			return Message.error();
		}
		return Message.success(items); 
	}
	
	// 即将揭晓
	@RequestMapping("/soonItems")
	public Message soonItems(){
		List<ItemVo> items = null;
		try {
			items =  itemService.soonItems();
		} catch (Exception e) {
			log.error(e.getMessage() , e);
			return Message.error();
		}
		return Message.success(items);
	}
	
	// 新品上架
	@RequestMapping("/newItems")
	public Message newItems(){
		List<ItemVo> items = null;
		try {
			items =  itemService.newItems();
		} catch (Exception e) {
			log.error(e.getMessage() , e);
			return Message.error();
		}
		return Message.success(items);
	}
	
	@RequestMapping("/findItems/{brandId}-{categoryId}-{property}-{direction}")
	public Message findItems(@PathVariable("brandId")String brandId , @PathVariable("categoryId")String categoryId , 
			@PathVariable("property")String property , @PathVariable("direction")String direction){
		return Message.success(null);
	}
	
}
