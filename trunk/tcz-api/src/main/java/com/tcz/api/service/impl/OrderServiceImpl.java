package com.tcz.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcz.api.mapper.OrderMapper;
import com.tcz.api.model.po.Order;
import com.tcz.api.service.OrderService;

@Service
public class OrderServiceImpl extends AbstractService<Order, Long> implements OrderService{
	
	@Autowired
	private OrderMapper orderMapper;

	@Autowired
	public void setBaseMapper() {
		super.setBaseMapper(orderMapper);
	}

}
