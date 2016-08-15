package com.tcz.api.mapper;

import com.tcz.api.model.po.Lottery;
import com.tcz.api.model.vo.item.LotteryVo;

public interface LotteryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Lottery record);

    int insertSelective(Lottery record);

    Lottery selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Lottery record);

    int updateByPrimaryKey(Lottery record);

	LotteryVo findByGoodsId(String goodsId);
}