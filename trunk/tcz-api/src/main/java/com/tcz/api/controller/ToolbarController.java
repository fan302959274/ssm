package com.tcz.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcz.api.model.po.Member;
import com.tcz.api.service.MemberService;
import com.tcz.core.rest.Message;

/**
 * Controller - toolbar
 * 
 * @author candy.tam
 *
 */
@RestController
@RequestMapping("/toolbar")
public class ToolbarController {
	@Autowired
	MemberService memberService;

	@RequestMapping("/currentMember")
	public Message currentMember(){
		Member member = new Member();
		member.setUserPhoto("http://faceimg.1yyg.com/UserFace/20160614184701355.jpg");
		member.setName("candy.tam");
		return Message.success(member);
	}
	
	@RequestMapping("/userLogin")
	public Message userLogin(String name , String pwd , String auth){
		return Message.build("201", "");
	}
}
