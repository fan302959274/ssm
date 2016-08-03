package com.tcz.api.config.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan(basePackages = { "com.tcz.cms.controller" , "com.tcz.cms.plugin"})
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter{
	
}
