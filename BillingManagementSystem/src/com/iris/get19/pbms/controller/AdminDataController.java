package com.iris.get19.pbms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iris.get19.pbms.dao.DeveloperDao;
import com.iris.get19.pbms.dao.ProjectDao;
import com.iris.get19.pbms.dao.RoleDao;
import com.iris.get19.pbms.dao.model.Project;
import com.iris.get19.pbms.dao.model.ProjectConfiguration;
import com.iris.get19.pbms.dao.model.Role;
public class AdminDataController {
	
	@Autowired
	ProjectDao projectDao;
	
	@Autowired
	DeveloperDao developerDao;
	
	@Autowired
	RoleDao roleDao;
	
	@RequestMapping(value="/fetchProjectConfigConfiguration",method=RequestMethod.GET)
	public @ResponseBody  List<ProjectConfiguration>  getProjectConfiguration() {
		System.out.println("I have reached here");
		 List<ProjectConfiguration> configList = projectDao.getAllProjectConfig();
		return configList;
	}
	@RequestMapping(value="/fetchProjects",method=RequestMethod.GET)
	public @ResponseBody List<Project> getProjects() {
		List<Project> projectsList= projectDao.getAllProject();
		return projectsList;
	}
	@RequestMapping(value="/fetchRoles",method=RequestMethod.GET)
	public @ResponseBody List<Role> getRoles() {
		List<Role> rolesList= roleDao.getAllRole();
		return rolesList;
	}
}
