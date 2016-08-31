package com.tcz.api.service;

import java.util.List;
import java.util.Map;

import com.tcz.api.model.po.Member;
import com.tcz.api.utils.Response;
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
	 Response<Map<String, Object>> login(String account,String password);
	 /**
	  * 注册
	  * @param account
	  * @param password
	  * @return
	  */
	 Response<Map<String, Object>> register(String account,String password);
	 
}
