package com.tcz.api.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcz.core.rest.Message;

@RestController
@RequestMapping("/cart")
public class CartController {

	@RequestMapping("/getBarcodernoInfo")
	public Message getBarcodernoInfo(String goodsId){
		//Map<String, Object> data = new HashMap<String, Object>();
		//data.put("count", 2);
		//data.put("money", 2);
		List<Map<String, Object>> data = new ArrayList<>();
		Map<String, Object> item = new HashMap<>();
		item.put("codeID", 7574883); // 商品ID
		item.put("codePeriod", 129985); // 商品期数
		item.put("codeQuantity", 65); // 总数量
		item.put("codeSales", 40); // 已购数量
		item.put("codeType", 0); // 商品类型(限购,促销)
		item.put("codeLimitBuy", 0); // 限购数量
		item.put("myLimitSales", 0); // 用户限购数量
		item.put("goodsID", 21876); // 货号ID
		data.add(item);
		return Message.success(data);
	}
	
	//{"code":0,"listItems":[{"codeID":7574883,"codePeriod":129985,"codeQuantity":65,"codeSales":40,"codeType":0,"codeLimitBuy":0,"myLimitSales":0,"goodsID":21876}]}
}
