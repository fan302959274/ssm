package com.tcz.api.service;

import java.util.List;
import java.util.Map;

import com.tcz.api.utils.ResponseUtil;

/**
 * 
 * @author cf
 *
 */
public interface MemberService {
	/**
	 * 云购记录
	 * 
	 * @param id
	 * @return
	 */
	ResponseUtil<List<Map<String, Object>>> selectYunRecord(Long id);

	/**
	 * 获得的商品
	 * 
	 * @param id
	 * @return
	 */
	ResponseUtil<List<Map<String, Object>>> productHaving(Long id);

	/**
	 * 登录
	 * 
	 * @param account
	 * @param password
	 * @return
	 */
	ResponseUtil<Map<String, Object>> login(String account, String password,String captcha,String captchaId);

	/**
	 * 注册
	 * 
	 * @param account
	 * @param password
	 * @return
	 */
	ResponseUtil<Map<String, Object>> register(String account, String password);

}
