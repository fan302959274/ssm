package com.tcz.api.controller;

import org.mockito.cglib.beans.BeanCopier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcz.api.model.po.Order;
import com.tcz.api.model.vo.item.OrderVo;
import com.tcz.api.service.OrderService;
import com.tcz.core.rest.Message;

/**
 * @author 阿康
 *
 */
@RestController
@RequestMapping("/order")
public class OrderController {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/orderDetail/{id}")
	public Message getOrderById(@PathVariable("id")Long id){
		try {
			Order order = orderService.selectByPrimaryKey(id);
			OrderVo vo  = new OrderVo();
			BeanUtils.copyProperties(order, vo);
			BeanCopier.create(Order.class, OrderVo.class, Boolean.FALSE).copy(order, vo, null);
			return Message.success(vo);
		} catch (Exception e) {
			log.error(e.getMessage() , e);
			return Message.error();
		}
	}
}
