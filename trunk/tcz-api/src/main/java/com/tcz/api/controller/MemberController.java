package com.tcz.api.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcz.api.model.po.Order;
import com.tcz.api.model.vo.item.OrderVo;
import com.tcz.api.service.MemberService;
import com.tcz.api.service.OrderService;
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
}
