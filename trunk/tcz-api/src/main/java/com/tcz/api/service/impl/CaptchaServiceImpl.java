/*
 * Copyright 2005-2015 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 */
package com.tcz.api.service.impl;

import java.awt.image.BufferedImage;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.octo.captcha.service.CaptchaServiceException;
import com.tcz.api.service.CaptchaService;

/**
 * Service - 验证码
 * 
 * @author SHOP++ Team
 * @version 4.0
 */
@Service("captchaServiceImpl")
public class CaptchaServiceImpl implements CaptchaService {

	@Resource(name = "imageCaptchaService")
	private com.octo.captcha.service.CaptchaService imageCaptchaService;

	public BufferedImage buildImage(String captchaId) {
		Assert.hasText(captchaId);

		return (BufferedImage) imageCaptchaService.getChallengeForID(captchaId);
	}

	public boolean isValid(String captchaId, String captcha) {
		try {
			return imageCaptchaService.validateResponseForID(captchaId, captcha.toUpperCase());
		} catch (CaptchaServiceException e) {
			return false;
		}
	}

}