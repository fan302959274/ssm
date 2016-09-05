package com.tcz.api.config.captcha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.octo.captcha.service.image.DefaultManageableImageCaptchaService;

@Service
public class CaptchaConfig {
	
	@Autowired
	CaptchaEngine captchaEngine;
	
	@Bean(name="imageCaptchaService")
	public DefaultManageableImageCaptchaService getImageCaptchaService(){
		DefaultManageableImageCaptchaService imageCaptchaService = new DefaultManageableImageCaptchaService();
		imageCaptchaService.setCaptchaEngine(captchaEngine);
		imageCaptchaService.setMinGuarantedStorageDelayInSeconds(600);
		return imageCaptchaService;
	}
	
}
