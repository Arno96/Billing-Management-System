package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomePageController {
	
	@RequestMapping(value= "/", method=RequestMethod.GET)
	public String openUp() {
		return "loginPage";
	}
	
	@RequestMapping(value= "/login", method=RequestMethod.GET)
	public String loginpage() {
		return "loginPage";
	}
}
