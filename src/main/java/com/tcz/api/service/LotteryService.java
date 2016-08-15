package com.tcz.api.service;

import com.tcz.api.model.po.Lottery;

public interface LotteryService {

	Lottery findByGoodsId(String goodsId);
	
}
