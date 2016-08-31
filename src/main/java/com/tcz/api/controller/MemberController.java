package com.tcz.api.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcz.api.model.po.Member;
import com.tcz.api.service.MemberService;
import com.tcz.api.utils.Response;
import com.tcz.api.utils.ResultEnum;
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
	 * 会员注册
	 * @param account
	 * @param password
	 * @return
	 */
	 
	@RequestMapping("/register")
	public Response<Member> register(String account, String password){
		return memberService.register(account,password);
	}
	
	/**
	 * 会员登录
	 * @param account
	 * @param password
	 * @return
	 */
	
	@RequestMapping("/login")
	@ResponseBody
	public Response<Member>  login(String account, String password){
			return memberService.login(account,password);
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
