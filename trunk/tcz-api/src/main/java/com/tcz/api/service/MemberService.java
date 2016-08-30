package com.tcz.api.service;

import java.util.List;
import java.util.Map;

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
	 Boolean login(String account,String password);
	 /**
	  * 注册
	  * @param account
	  * @param password
	  * @return
	  */
	 Boolean register(String account,String password);
	 
}
