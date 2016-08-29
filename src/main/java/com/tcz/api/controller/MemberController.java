package com.tcz.api.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcz.api.service.MemberService;
import com.tcz.core.rest.Message;

/**
 * 会员
 * @author cf
 *
 */
@RestController
@RequestMapping("/member")
public class MemberController {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private MemberService memberService;
	
	
	/**
	 * 会员登录
	 * @return
	 */
	@RequestMapping("/login")
	public Boolean login(String account, String password){
		try {
			return memberService.login(account,password);
		} catch (Exception e) {
			log.error(e.getMessage() , e);
			return false;
		}
	}
	
	/**
	 * 云购记录
	 * @return
	 */
	@RequestMapping("/yunRecord")
	public Message getOrderById(){
		try {
			List<Map<String, Object>> mapList = memberService.selectYunRecord(1l);
			return Message.success(mapList);
		} catch (Exception e) {
			log.error(e.getMessage() , e);
			return Message.error();
		}
	}
	/**
	 * 获得的商品
	 * @return
	 */
	@RequestMapping("/productHaving")
	public Message productHaving(){
		try {
			return Message.success(null);
		} catch (Exception e) {
			log.error(e.getMessage() , e);
			return Message.error();
		}
	}
	/**
	 * 我的关注
	 * @return
	 */
	@RequestMapping("/myCollection")
	public Message myCollection(){
		try {
			return Message.success(null);
		} catch (Exception e) {
			log.error(e.getMessage() , e);
			return Message.error();
		}
	}
	
}
