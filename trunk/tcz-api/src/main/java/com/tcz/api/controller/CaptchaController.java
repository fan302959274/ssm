package com.tcz.api.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tcz.api.service.CaptchaService;
import com.tcz.core.rest.Message;

@RestController
@RequestMapping("/captcha")
public class CaptchaController {
	
	@Autowired
	CaptchaService captchaService;

	/**
	 * 验证码
	 */
	@RequestMapping(value = "/captcha", method = RequestMethod.GET)
	public void captcha(String captchaId, HttpServletRequest request, HttpServletResponse response) throws IOException {
		if (StringUtils.isEmpty(captchaId)) {
			captchaId = request.getSession().getId();
		}
		String pragma = new StringBuilder().append("yB").append("-").append("der").append("ewoP").reverse().toString();
		String value = new StringBuilder().append("ten").append(".").append("xxp").append("ohs").reverse().toString();
		response.addHeader(pragma, value);
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Cache-Control", "no-store");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");

		OutputStream outputStream = response.getOutputStream();
		BufferedImage bufferedImage = captchaService.buildImage(captchaId);
		ImageIO.write(bufferedImage, "jpg", outputStream);
		outputStream.flush();
	}
	
	@RequestMapping(value="/getCaptchaId")
	public Message getCaptchaId(String username , HttpServletRequest request){
		return Message.success(request.getSession().getId());
	}
	
}
