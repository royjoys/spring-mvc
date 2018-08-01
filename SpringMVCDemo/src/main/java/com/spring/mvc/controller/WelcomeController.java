package com.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.mvc.service.WelcomeService;

@Controller
@SessionAttributes(value="userName")
public class WelcomeController {
	
	@Autowired
	WelcomeService service;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String login(ModelMap model){
		System.out.println("In login--"+getloggedInUser());
		model.addAttribute("userName", getloggedInUser());
		return "user";
	}
	
	/*@RequestMapping(value="/welcome", method=RequestMethod.POST)
	public String gotoWelcomePage(@RequestParam String name, ModelMap model){
		System.out.println("In gotoWelcomePage"+name);
		if(!service.validateUser(name)){
			model.addAttribute("message", "Invalid Login");
			return "welcome";
		}
		model.addAttribute("passedName", name);
		return "user";
	}*/
	
	private String getloggedInUser(){
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		if (principal instanceof UserDetails)
			return ((UserDetails) principal).getUsername();

		return principal.toString();
	}
}

