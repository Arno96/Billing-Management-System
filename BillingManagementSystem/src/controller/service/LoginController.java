package controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import controller.service.dao.impl.*;
import controller.service.dao.model.*;

@Controller
public class LoginController {
	
	@Autowired 
	private DeveloperDao developerDao;
	
	@RequestMapping(value="validateRole",method=RequestMethod.POST)
	public String validateRole(@RequestParam("id") int id,@RequestParam("pwd") String pass, Model map) {
		Developer devobj = developerDao.getDeveloper(id,pass);
		if(devobj==null){
			System.out.println("Inside If");
			return "login";
		} else {
			System.out.println("Inside Else");
			if(devobj.getRole().equals("Admin"))
			{
				map.addAttribute(devobj);
				return "Admin";
			}
			else if(devobj.getRole().equals("Data entry operator")){
				map.addAttribute(devobj);
				return "DataEntry";
			}
		}
		return null;
	}
}
