package com.tcz.api.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcz.api.model.po.Item;
import com.tcz.api.service.CartService;
import com.tcz.api.service.ItemService;

@Service("cartServiceImpl")
public class CartServiceImpl implements CartService{
	
	@Autowired
	private ItemService itemService;

	@Override
	public Map<String, Object> getCurrent(String cartDataSel) {
		List<Item> items = itemService.findByIds(getIds(cartDataSel));
		
		System.out.println(cartDataSel);
		Map<String, Object> data = new HashMap<>();
		data.put("listUpdate", Collections.emptyList());
		data.put("listOutDate", Collections.emptyList());
		data.put("unvalid", "");
		Integer count = 0;
		Integer money = 0;
		List<Map<String, Object>> listCart = new ArrayList<>();
		for(int i=0 ; i<items.size() ; i++){
			Item item = items.get(i);
			Map<String, Object> cart = new HashMap<>();
			cart.put("codeID", item.getId());
			cart.put("codePeriod", item.getPeriods());
			cart.put("codeQuantity", item.getPrice());
			cart.put("codeSales", item.getSales());
			cart.put("goodsPic", item.getImage());
			cart.put("goodsId", item.getGoodsId());
			cart.put("goodsName", item.getName());
			cart.put("codePrice", item.getPrice());
			cart.put("shopNum", getCount(cartDataSel, item.getId()));
			cart.put("codeType", 0);
			cart.put("codeLimitBuy", 0);
			cart.put("myLimitSales", 0);
			listCart.add(cart);
			count += getCount(cartDataSel, item.getId());
			money = count;
		}
		data.put("count", count);
		data.put("money", money);
		data.put("listCart", listCart);
		return data;
	}

	@Override
	public List<Map<String, Object>> getCartItemInfo(Long id) {
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
		return data;
	}
	
	// 3,2|1,1
	private List<Long> getIds(String cartDataSel){
		String idStr =  cartDataSel.split("\\|")[0];
		String[] idsTmp = idStr.split(",");
		List<Long> ids = new ArrayList<>();
		for(int i=0 ; i<idsTmp.length ; i++){
			String id = idsTmp[i];
			ids.add(Long.parseLong(id));
		}
		return ids;
	}
	
	private Integer getCount(String cartDataSel , Long id){
		String[] ids =  cartDataSel.split("\\|")[0].split(",");
		String[] nums = cartDataSel.split("\\|")[1].split(",");
		for(int i=0 ; i<ids.length ; i++){
			if(ids[i].equals(id.toString())){
				return Integer.parseInt(nums[i]);
			}
		}
		return 0;
	}

}
