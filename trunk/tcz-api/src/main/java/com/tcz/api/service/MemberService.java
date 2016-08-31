package com.tcz.api.service;

import java.util.List;
import java.util.Map;

import com.tcz.api.utils.ResultEnum;

/**
 * 
 * @author cf
 *
 */
public interface MemberService {
	 /**
	  * 云购记录
	  * @param id
	  * @return
	  */
	 List<Map<String, Object>> selectYunRecord(Long id);
	 /**
	  * 登录
	  * @param account
	  * @param password
	  * @return
	  */
	 ResultEnum login(String account,String password);
	 /**
	  * 注册
	  * @param account
	  * @param password
	  * @return
	  */
	 ResultEnum register(String account,String password);
	 
}
