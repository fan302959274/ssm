package com.tcz.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcz.api.model.vo.item.AdVo;
import com.tcz.api.model.vo.item.CurrentShoppVo;
import com.tcz.api.model.vo.item.ItemOwnerVo;
import com.tcz.api.model.vo.item.ItemVo;
import com.tcz.api.service.AdService;
import com.tcz.api.service.ItemService;
import com.tcz.core.rest.Message;

/**
 * Controller - 首页
 * 
 * @author candy.tam
 *
 */
@RestController
@RequestMapping("/index")
public class IndexController {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ItemService itemService;
	@Autowired
	AdService adService;
	
	// 正在揭晓
	@RequestMapping("/raffleItems")
	public Message raffleItems(){
		List<ItemVo> items = null;
		try {
			items =  itemService.newItems();
		} catch (Exception e) {
			log.error(e.getMessage() , e);
			return Message.error();
		}
		return Message.success(items);
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
	
	// 首页轮播广告
	@RequestMapping("/findAds/{adPositionId}")
	public Message findAds(@PathVariable("adPositionId")Long adPositionId){
		List<AdVo> adVos = null;
		try {
			adVos =  adService.findAds(adPositionId);
		} catch (Exception e) {
			log.error(e.getMessage() , e);
			return Message.error();
		}
		return Message.success(adVos); 
	}
	
	// 正在云购
	@RequestMapping("/currentShoppList")
	public Message currentShoppList(){
		List<CurrentShoppVo> shoppVos = new ArrayList<>();
		CurrentShoppVo shoppVo = new CurrentShoppVo();
		shoppVo.setItemPath("1");
		shoppVo.setItemTitle("蓝月亮 亮白增艳洗衣液（自然清香）3kg/瓶");
		shoppVo.setUserName("物久迈有");
		shoppVo.setUserPhoto("http://faceimg.1yyg.com/UserFace/20160417170340315.jpg");
		shoppVo.setUserWeb("http://u.1yyg.com/1008747465");
		shoppVos.add(shoppVo);
		shoppVos.add(shoppVo);
		shoppVos.add(shoppVo);
		shoppVos.add(shoppVo);
		shoppVos.add(shoppVo);
		shoppVos.add(shoppVo);
		return Message.success(shoppVos);
	}
	
	// 商品获取者
	@RequestMapping("/itemOwner")
	public Message itemOwner(){
		ItemOwnerVo owner = new ItemOwnerVo();
		owner.setItemImage("http://goodsimg.1yyg.com/goodspic/pic-200-200/20151026181548493.jpg");
		owner.setItemTitle("蓝月亮 亮白增艳洗衣液（自然清香）3kg/瓶");
		owner.setPeriods(1);
		owner.setUserName("物久迈有");
		owner.setUserWeb("http://u.1yyg.com/1008747465");
		owner.setIpAddr("上海");
		return Message.success(owner);
	}
}
