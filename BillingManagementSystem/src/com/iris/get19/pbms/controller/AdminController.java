package com.iris.get19.pbms.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.iris.get19.pbms.dao.DeveloperDao;
import com.iris.get19.pbms.dao.ProjectDao;
import com.iris.get19.pbms.dao.RoleDao;
import com.iris.get19.pbms.dao.model.DataEntryOperator;
import com.iris.get19.pbms.dao.model.Developer;
import com.iris.get19.pbms.dao.model.Project;
import com.iris.get19.pbms.dao.model.ProjectAllocation;
import com.iris.get19.pbms.dao.model.ProjectConfiguration;
import com.iris.get19.pbms.dao.model.Role;
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
		List<ProjectAllocation> dList = developerDao.getAllAllocate();
		
		
		map.addAttribute("devL", dList);
		return "DevForm";
	}
	
	@RequestMapping(value= {"projectBilling"},method=RequestMethod.GET)
	public String ProjBill(ModelMap map)
	{
		List<Project> pList = projectDao.getAllProject();
	
		
		map.addAttribute("pList", pList);
		return "ProjForm";
	}
	
	/*@RequestMapping(value= {"BillProj"},method=RequestMethod.GET)
	public String ProjBills(@RequestParam String month,@RequestParam int projectId,ModelMap map) {
		
	}*/
	
	
	@RequestMapping(value= {"Bill"},method=RequestMethod.GET)
	public String DevBills(@RequestParam String month,@RequestParam int developerId,ModelMap map)
	{
		ProjectAllocation configObj = developerDao.getConfig(developerId);
		System.out.println(configObj.getPcObj() .getPER_HOUR_BILLING());
		
		double perHourBilling=configObj.getPcObj() .getPER_HOUR_BILLING();
		
		
		DataEntryOperator deo=developerDao.getBill(developerId, month);
		System.out.println("Data Entry Operator : "+deo);
		
		System.out.println(deo.getfullDay());
		double halfDay=deo.gethalfDay()*4.5;
		double fullDay=deo.getfullDay()*9;
		double bill=(halfDay*perHourBilling+fullDay*perHourBilling);
		map.addAttribute("bill",bill);
		map.addAttribute("de", developerId);
		map.addAttribute("mo",month);
		return "devDetail";
	}
	@RequestMapping(value= {"BillProj"},method=RequestMethod.GET)
	public String BillingProject(@RequestParam(name="projectId") int id,@RequestParam(name="month") String month,ModelMap map) {
		
		System.out.println(id + month);
		double bill = 0;
		List<ProjectConfiguration> projConfigList=projectDao.getAllConfigId(id);
		for(ProjectConfiguration configObj: projConfigList)
		{
			System.out.println(configObj.getCONFIGURATION_ID());
			int cid = configObj.getCONFIGURATION_ID();
			int perHourBilling = configObj.getPER_HOUR_BILLING();
			System.out.println(perHourBilling);
			ProjectAllocation proAllocate = developerDao.getProAllocationObj(cid);
			System.out.println(proAllocate.getallocationId());
			int developerId = proAllocate.getdObj().getDeveloperId();
			System.out.println(developerId);
			DataEntryOperator deo=developerDao.getBill(developerId, month);
			System.out.println("Data Entry Operator : "+deo);
			double halfDay=deo.gethalfDay()*4.5;
			double fullDay=deo.getfullDay()*9;
			bill+=(halfDay*perHourBilling+fullDay*perHourBilling);
		}
		map.addAttribute("bill", bill);
		
		/*System.out.println(projConfig.getProjectObj().);
		
		
		
		DataEntryOperator deo=developerDao.getBill(id, name);
		System.out.println("Data Entry Operator : "+deo);
		
		System.out.println(deo.getfullDay());*/
		
		return "ProjectBilling";
	}
	
}
