package com.tcz.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcz.api.model.vo.item.AdVo;
import com.tcz.api.service.AdService;
import com.tcz.core.rest.Message;

/**
 * Controller - Ad
 * 
 * @author candy.tam
 *
 */
@RestController
@RequestMapping("/ad")
public class AdController {
	
	private Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	AdService adService;
	
	@RequestMapping("/findAds/{adPositionId}")
	public Message findAds(@PathVariable("adPositionId")Long adPositionId){
		List<AdVo> adVos = null;
		try {
			adVos =  adService.findAds(adPositionId);
		} catch (Exception e) {
			log.error(e.getMessage() , e);
			return Message.error();
		}
		return Message.success(adVos); 
	}
}
