package com.tcz.api.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcz.api.mapper.AdMapper;
import com.tcz.api.model.vo.item.AdVo;
import com.tcz.api.service.AdService;

@Service("adServiceImpl")
public class AdServiceImpl implements AdService {
	@Autowired
	AdMapper adMapper;

	@Override
	public List<AdVo> findAds(Long adPositionId) {
		return adMapper.findAds(adPositionId);
	}
	
}
