package com.tcz.api.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcz.api.model.vo.item.AdVo;
import com.tcz.api.model.vo.item.CurrentShoppVo;
import com.tcz.api.model.vo.item.LotteryVo;
import com.tcz.api.model.vo.item.ItemVo;
import com.tcz.api.service.AdService;
import com.tcz.api.service.ItemService;
import com.tcz.api.service.LotteryService;
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
	ItemService itemService;
	@Autowired
	AdService adService;
	@Autowired
	LotteryService lotteryService;
	
	// 正在揭晓
	@RequestMapping("/raffleItems")
	public Message raffleItems(){
		List<ItemVo> items = null;
		try {
			items = itemService.newItems();
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
	@RequestMapping("/findAds")
	public Message findAds(Long adPositionId){
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
	@RequestMapping("/lottery")
	public Message lottery(String goodsId){
		LotteryVo lottery = null;
		try {
			lottery = lotteryService.findByGoodsId(goodsId);
		} catch (Exception e) {
			log.error(e.getMessage() , e);
			return Message.error();
		}
		return Message.success(lottery);
	}
	
	// 系统时间
	@RequestMapping("/serverTime")
	public Message serverTime(String time){
		Long diffSeconds = 0L;
		try {
			Date clientDate = DateUtils.parseDate(time, "yyyy-MM-dd HH:mm:ss");
			diffSeconds = (new Date().getTime() - clientDate.getTime()) / 1000;
		} catch (ParseException e) {
			log.error(e.getMessage() , e);
			return Message.error();
		}
		return Message.success(diffSeconds);
	}
	
	// 总共购买数量
	@RequestMapping("/totalBuyCount")
	public Message totalBuyCount(){
		Map<String, String> data = new HashMap<>();
		data.put("fundTotal", "1000000");
		data.put("count", "0000100001");
		return Message.success(data);
	}
}
