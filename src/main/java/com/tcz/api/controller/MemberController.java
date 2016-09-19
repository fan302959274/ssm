package com.tcz.api.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.tcz.api.model.po.Member;
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
	public ResponseUtil<Member> login(HttpServletRequest request,String account,
			String password,String captcha) {
		ResponseUtil<Member> resp = new  ResponseUtil<Member>();
		HttpSession session = request.getSession();
		String captchaId = session.getId();
		resp = memberService.login(account, password,captcha,captchaId);
		//设置登录用户session
		if(null!=resp&&null!=resp.getResult()){
			session.setAttribute("user", JSONObject.toJSON(resp.getResult()));
		}
		return resp;
	}

	/**
	 * 云购记录
	 * @param 商品状态:status
	 * @return
	 */
	@RequestMapping("/yunRecord")
	public ResponseUtil<List<Map<String, Object>>> yunRecord(HttpServletRequest request,String status) {
		HttpSession session = request.getSession();
		JSONObject userO = (JSONObject) session.getAttribute("user");
		if(null!=userO){
			return memberService.selectYunRecord(userO.getLong("id"),status);
		}else{
			log.info("用户未登录!");
		}
		return null;
		
	}

	/**
	 * 获得的商品
	 * 
	 * @return
	 */
	@RequestMapping("/productHaving")
	public ResponseUtil<List<Map<String, Object>>> productHaving(HttpServletRequest request,String status) {
		HttpSession session = request.getSession();
		JSONObject userO = (JSONObject) session.getAttribute("user");
		if(null!=userO){
			return  memberService.productHaving(userO.getLong("id"),status);
		}else{
			log.info("用户未登录!");
		}
		return null;
			
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
