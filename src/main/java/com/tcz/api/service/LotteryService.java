package com.tcz.api.service;

import com.tcz.api.model.vo.item.LotteryVo;

public interface LotteryService {

	LotteryVo findByGoodsId(String goodsId);
	
}
