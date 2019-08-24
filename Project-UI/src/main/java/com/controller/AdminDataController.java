package com.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
public class AdminDataController {
	
//	@Autowired
//	ProjectDao projectDao;
//	
//	@Autowired
//	DeveloperDao developerDao;
//	
//	@Autowired
//	RoleDao roleDao;
	
	@RequestMapping(value="/get",method=RequestMethod.GET)
	public @ResponseBody void get() {
		System.out.println("I have reached get");
	}
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public @ResponseBody void insert() {
		System.out.println("I have reached insert");
	}
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public @ResponseBody void delete() {
		System.out.println("I have reached delete");
	}
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public @ResponseBody void update() {
		System.out.println("I have reached update");
	}
//	@RequestMapping(value="/fetchProjects",method=RequestMethod.GET)
//	public @ResponseBody List<Project> getProjects() {
//		List<Project> projectsList= projectDao.getAllProject();
//		return projectsList;
//	}
//	@RequestMapping(value="/fetchRoles",method=RequestMethod.GET)
//	public @ResponseBody List<Role> getRoles() {
//		List<Role> rolesList= roleDao.getAllRole();
//		return rolesList;
//	}
}
