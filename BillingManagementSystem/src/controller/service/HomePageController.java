package controller.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomePageController {
	
	@RequestMapping(value= "/", method=RequestMethod.GET)
	public String openUp() {
		return "Home";
	}
	
	@RequestMapping(value= "/login", method=RequestMethod.GET)
	public String loginpage() {
		return "login";
	}
}
