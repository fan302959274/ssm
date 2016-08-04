package com.tcz.api;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ServletComponentScan
@SpringBootApplication
@EnableTransactionManagement 
@EnableAspectJAutoProxy
@EnableWebMvc
@EnableCaching
@ComponentScan(basePackages = {"com.tcz.api"}, excludeFilters = {@Filter(type = FilterType.ANNOTATION, value = Controller.class)})
public class TczApiApplication {
    
	public static void main(String[] args) throws Exception {
		SpringApplication.run(TczApiApplication.class, args);
	}
	
}
