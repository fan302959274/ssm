package com.tcz.api.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcz.api.model.po.Item;
import com.tcz.api.service.ItemService;
import com.tcz.api.utils.WebUtils;
import com.tcz.core.rest.Message;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	ItemService itemService;
	
	//{"code":0,"listItems":[{"codeID":7574883,"codePeriod":129985,"codeQuantity":65,"codeSales":40,"codeType":0,"codeLimitBuy":0,"myLimitSales":0,"goodsID":21876}]}
	@RequestMapping("/getBarcodernoInfo")
	public Message getBarcodernoInfo(Long id){
		//Map<String, Object> data = new HashMap<String, Object>();
		//data.put("count", 2);
		//data.put("money", 2);
		Item item = itemService.findById(id);
		List<Map<String, Object>> data = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		map.put("codeID", item.getId()); // 商品ID
		map.put("codePeriod", item.getPeriods()); // 商品期数
		map.put("codeQuantity", item.getPrice()); // 总数量
		map.put("codeSales", item.getSales()); // 已购数量
		map.put("codeType", 0); // 商品类型(限购,促销)
		map.put("codeLimitBuy", 0); // 限购数量
		map.put("myLimitSales", 0); // 用户限购数量
		map.put("goodsID", item.getGoodsId()); // 货号ID
		data.add(map);
		return Message.success(data);
	}
	
	// {"code":0,"count":1,"money":1,"listCart":[{"codeID":7910452,"codePeriod":312685,"codeQuantity":1688,"codeSales":1644,"goodsPic":"20151026181548493.jpg","goodsID":22593,"goodsName":"平安银行 招财进宝金章 Au9999 5g","codePrice":"1688","shopNum":1,"codeType":0,"codeLimitBuy":0,"myLimitSales":"0"}],"listUpdate":[],"listOutDate":[],"unvalid":""}
	@RequestMapping("/cartLabel")
	public Message cartLabel(HttpServletRequest request){
		String cartDataSel =  WebUtils.getCookie(request , "_CartDataSel");
		System.out.println(cartDataSel);
		Map<String, Object> data = new HashMap<>();
		data.put("count", 1);
		data.put("money", 1);
		data.put("listUpdate", Collections.emptyList());
		data.put("listOutDate", Collections.emptyList());
		data.put("unvalid", "");
		List<Map<String, Object>> listCart = new ArrayList<>();
		Map<String, Object> cart = new HashMap<>();
		cart.put("codeID", 1);
		cart.put("codePeriod", 19);
		cart.put("codeQuantity", 10);
		cart.put("codeSales", 5);
		cart.put("goodsPic", "20151026181548493.jpg");
		cart.put("goodsId", 22593);
		cart.put("goodsName", "平安银行 招财进宝金章 Au9999 5g");
		cart.put("codePrice", 1688);
		cart.put("shopNum", 1);
		cart.put("codeType", 0);
		cart.put("codeLimitBuy", 0);
		cart.put("myLimitSales", 0);
		listCart.add(cart);
		data.put("listCart", listCart);
		return Message.success(data);
	}
}
