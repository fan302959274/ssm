package com.tcz.api.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcz.api.service.CartService;
import com.tcz.api.utils.WebUtils;
import com.tcz.core.rest.Message;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	CartService cartService;
	
	//{"code":0,"listItems":[{"codeID":7574883,"codePeriod":129985,"codeQuantity":65,"codeSales":40,"codeType":0,"codeLimitBuy":0,"myLimitSales":0,"goodsID":21876}]}
	@RequestMapping("/getBarcodernoInfo")
	public Message getBarcodernoInfo(Long id){
		List<Map<String, Object>> result = null;
		try {
			result = cartService.getCartItemInfo(id);
		} catch (Exception e) {
			logger.error(e.getMessage() , e);
		}
		return Message.success(result);
	}
	
	// {"code":0,"count":1,"money":1,"listCart":[{"codeID":7910452,"codePeriod":312685,"codeQuantity":1688,"codeSales":1644,"goodsPic":"20151026181548493.jpg","goodsID":22593,"goodsName":"平安银行 招财进宝金章 Au9999 5g","codePrice":"1688","shopNum":1,"codeType":0,"codeLimitBuy":0,"myLimitSales":"0"}],"listUpdate":[],"listOutDate":[],"unvalid":""}
	@RequestMapping("/cartLabel")
	public Message cartLabel(HttpServletRequest request){
		String cartDataSel = WebUtils.getCookie(request , "_CartDataSel");
	 	Map<String, Object> result = null;
	 	try {			
	 		result = cartService.getCurrent(cartDataSel);
		} catch (Exception e) {
			logger.error(e.getMessage() , e);
		}
		return Message.success(result);
	}
	
}
