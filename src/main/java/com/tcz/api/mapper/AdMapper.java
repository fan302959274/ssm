package com.tcz.api.mapper;

import java.util.List;
import com.tcz.api.model.po.Ad;
import com.tcz.api.model.vo.item.AdVo;

public interface AdMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Ad record);

    int insertSelective(Ad record);

    Ad selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Ad record);

    int updateByPrimaryKey(Ad record);

	List<AdVo> findAds(Long adPositionId);
}