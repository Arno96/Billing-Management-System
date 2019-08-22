package controller.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import controller.service.dao.model.*;
import controller.service.dao.impl.*;
@Controller
public class AdminController {
	
	@Autowired 
	private ProjectDao projectDao;
	
	@Autowired
	private DeveloperDao developerDao;
	@Autowired
	private RoleDao roleDao;
	
	@RequestMapping(value= {"AddProj"},method=RequestMethod.GET)
	public String viewAdmin(ModelMap map) {
		List<Project> pro = projectDao.getAllProject();
		map.addAttribute("proj", pro);
		ProjectConfiguration pObj = new ProjectConfiguration();
		map.addAttribute("pObj", pObj);
		Role rObj = new Role();
		map.addAttribute("rObj",rObj);
		List<Role> ro = roleDao.getAllRole();
		map.addAttribute("role",ro);
		return "AddProject";
	}
	
	@RequestMapping(value= {"AddDev"},method=RequestMethod.GET)
	public String addDev(ModelMap map)
	{
		ProjectAllocation paObj=new ProjectAllocation();
		map.addAttribute("pObj", paObj);
		List<ProjectConfiguration> projCon = projectDao.getAllProjectConfig();
		map.addAttribute("projCon", projCon);
		List<Developer> dev= developerDao.getAllDeveloper();
		map.addAttribute("devl",dev);
		return "ViewDev";
	}
	
	@RequestMapping(value= {"submitConfig"},method=RequestMethod.GET)
	public String submitConfig(@ModelAttribute(name="pObj") ProjectConfiguration pObj, ModelMap map) {
		boolean saved = projectDao.setProjectConfig(pObj);
		if(saved) {
			return "Admin";
		} else {
			return "AddProject";
		}
	}
	
	@RequestMapping(value= {"submitAllocate"},method=RequestMethod.GET)
	public String submitAllocate(@ModelAttribute(name="pObj") ProjectAllocation pObj, ModelMap map) {
		boolean saved = projectDao.setProjectAllocate(pObj);
		if(saved) {
			return "Admin";
		} else {
			return "ViewDev";
		}
	}
	
	@RequestMapping(value= {"DevBilling"},method=RequestMethod.GET)
	public String DevBill(ModelMap map)
	{
		List<Developer> dList = developerDao.getAllDeveloper();
		List<Developer>	devL = new ArrayList<Developer>();
		for(Developer d : dList)
		{
			if(d.getRole().equals("Developer")) {
				
				devL.add(d);
			}
		}
		map.addAttribute("devL", devL);
		return "DevForm";
	}
	
	@RequestMapping(value= {"Bill"},method=RequestMethod.GET)
	public String DevBills(@RequestParam(name="x") String month,@RequestParam(name="dev") Developer d,ModelMap map)
	{
		map.addAttribute("de", d);
		map.addAttribute("mo",month);
		return "devDetail";
	}
}
