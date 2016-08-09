package com.tcz.api.service;

import java.util.List;

import com.tcz.api.model.vo.item.AdVo;

/**
 * Service - AD
 * 
 * @author candy.tam
 *
 */
public interface AdService {
	
	List<AdVo> findAds(Long adPositionId);

}
