package com.tcz.api.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表但是判断(手机号、邮箱)
 * 
 * @author cf 2016年7月27日下午6:31:01
 */
public class RegexUtils {

	// 手机号判断
	public static boolean isMobileNO(String mobiles) {
		Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
		Matcher m = p.matcher(mobiles);
		return m.matches();
	}

	// 邮箱判断
	public static boolean isEmail(String email) {
		Pattern regex = Pattern
				.compile("^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$");
		Matcher matcher = regex.matcher(email);
		return matcher.matches();
	}
}