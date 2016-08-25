package com.tcz.api.service;

import java.util.List;
import java.util.Map;

public interface CartService {
	
	/**
	 * 获取当前购物车
	 * 
	 * @return
	 */
	Map<String, Object> getCurrent(String cartDataSel);
	
	/**
	 * 获取商品购物车信息
	 * 
	 * @param id
	 * @return
	 */
	List<Map<String, Object>> getCartItemInfo(Long id);
	
	
	/**
	 * 获取商品
	 * @param id
	 * @return
	 */
	String getGoodsSalingByGoodsID(String goodsId);
	
}
