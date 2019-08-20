package com.getBatch3.BillingManagementFrontend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.getBatch3.BillingManagementBackend.Daos.DeveloperDao;
import com.getBatch3.BillingManagementBackend.Daos.ProjectDao;
import com.getBatch3.BillingManagementBackend.Daos.RoleDao;
import com.getBatch3.BillingManagementBackend.models.Developer;
import com.getBatch3.BillingManagementBackend.models.Project;
import com.getBatch3.BillingManagementBackend.models.ProjectAllocation;
import com.getBatch3.BillingManagementBackend.models.ProjectConfiguration;
import com.getBatch3.BillingManagementBackend.models.Role;

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
}
