package com.tcz.api.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcz.api.model.enums.ResultEnum;
import com.tcz.api.service.CaptchaService;
import com.tcz.api.service.MemberService;
import com.tcz.api.utils.ResponseUtil;
import com.tcz.core.rest.Message;

/**
 * 会员
 * 
 * @author cf
 *
 */
@RestController
@RequestMapping("/member")
public class MemberController {

	private Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private MemberService memberService;
	
	@Autowired
	CaptchaService captchaService;

	/**
	 * 会员注册
	 * 
	 * @param account
	 * @param password
	 * @return
	 */

	@RequestMapping("/register")
	public ResponseUtil<Map<String, Object>> register(String account,
			String password) {
		return memberService.register(account, password);
	}

	/**
	 * 会员登录
	 * 
	 * @param account
	 * @param password
	 * @return
	 */

	@RequestMapping("/login")
	public ResponseUtil<Map<String, Object>> login(HttpServletRequest request,String account,
			String password,String captcha) {
		ResponseUtil<Map<String, Object>> resp = new ResponseUtil<Map<String,Object>>();
		String captchaId = request.getSession().getId();
		if(null!=captcha&&!"".equals(captcha)){
			if(!captchaService.isValid(captchaId, captcha)){
				resp.setFacade(ResultEnum.VALIDATECODE_ERROR);
				return resp;
			}	
		}
		
		return memberService.login(account, password);
	}

	/**
	 * 云购记录
	 * 
	 * @return
	 */
	@RequestMapping("/yunRecord")
	public ResponseUtil<List<Map<String, Object>>> yunRecord() {
		return memberService.selectYunRecord(1l);
	}

	/**
	 * 获得的商品
	 * 
	 * @return
	 */
	@RequestMapping("/productHaving")
	public ResponseUtil<List<Map<String, Object>>> productHaving() {
			return  memberService.productHaving(1l);
	}

	/**
	 * 我的关注
	 * 
	 * @return
	 */
	@RequestMapping("/myCollection")
	public Message myCollection() {
		try {
			return Message.success(null);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return Message.error();
		}
	}
	
	/**
	 * 消费记录
	 * @return
	 */
	public ResponseUtil<List<Map<String, Object>>> consumeRecord(){
		return null;
	}

}
