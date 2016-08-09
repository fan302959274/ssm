package com.tcz.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcz.api.mapper.AdMapper;
import com.tcz.api.model.po.Ad;
import com.tcz.api.model.vo.item.AdVo;
import com.tcz.api.service.AdService;

@Service("adServiceImpl")
public class AdServiceImpl implements AdService {
	@Autowired
	AdMapper adMapper;

	@Override
	public List<AdVo> findAds(Long adPositionId) {
		List<Ad> ads = adMapper.findAds(adPositionId);
		List<AdVo> adVos = new ArrayList<>();
		for (int i = 0; i < ads.size(); i++) {
			AdVo adVo = new AdVo();
			BeanUtils.copyProperties(ads.get(i), adVo);
			adVos.add(adVo);
		}
		return adVos;
	}
	
}
