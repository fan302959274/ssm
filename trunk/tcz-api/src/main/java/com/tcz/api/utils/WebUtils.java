package com.tcz.api.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.util.Assert;

public class WebUtils {

	public static String getCookie(HttpServletRequest request, String name) {
		Assert.notNull(request);
		Assert.hasText(name);

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			try {
				name = URLEncoder.encode(name, "UTF-8");
				for (Cookie cookie : cookies) {
					if (name.equals(cookie.getName())) {
						return URLDecoder.decode(cookie.getValue(), "UTF-8");
					}
				}
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException(e.getMessage(), e);
			}
		}
		return null;
	}
	
}
