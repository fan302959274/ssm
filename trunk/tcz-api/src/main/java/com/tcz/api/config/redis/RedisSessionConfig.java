package com.tcz.api.config.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

@Configuration
@EnableRedisHttpSession
public class RedisSessionConfig {

	// 定制cookie session
	@Bean
    public CookieSerializer cookieSerializer() {
         DefaultCookieSerializer serializer = new DefaultCookieSerializer();
         serializer.setCookieName("JSESSIONID"); 
         serializer.setCookiePath("/"); 
         serializer.setDomainName(".tcz.com");
         return serializer;
    }
	
}
