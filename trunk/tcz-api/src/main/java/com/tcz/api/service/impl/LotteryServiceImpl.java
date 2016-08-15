package com.tcz.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcz.api.mapper.LotteryMapper;
import com.tcz.api.model.po.Lottery;
import com.tcz.api.service.LotteryService;

@Service("lotteryServiceImpl")
public class LotteryServiceImpl implements LotteryService{

	@Autowired
	LotteryMapper lotteryMapper;

	@Override
	public Lottery findByGoodsId(String goodsId) {
		return lotteryMapper.findByGoodsId(goodsId);
	}

}
