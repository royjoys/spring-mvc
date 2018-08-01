package com.spring.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ControllerAdvice
@EnableWebMvc
public class ControllerException {
	
	@ExceptionHandler(value=Exception.class)
	public String handleException(HttpServletRequest req, Exception ex){
		System.out.println("URL:"+req.getRequestURL()+" caused "+ex.getMessage());
		return "error";
		
	}

}
