package com.spring.mvc.service;

import org.springframework.stereotype.Service;

@Service
public class WelcomeService {

	public boolean validateUser(String name){
		return name.startsWith("S");
	}
}
