package com.iris.get19.pbms.controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iris.get19.pbms.dao.DeveloperDao;
import com.iris.get19.pbms.dao.ProjectDao;
import com.iris.get19.pbms.dao.model.DataEntryOperator;
import com.iris.get19.pbms.dao.model.Developer;
import com.iris.get19.pbms.dao.model.ProjectConfiguration;

@Controller
public class DataEntryController {
	
	@Autowired
	private DeveloperDao developerDao;
	
	@Autowired
	private ProjectDao projectDao;
	
	
	
	@RequestMapping(value="mark",method=RequestMethod.GET)
	public String marks(Model map)
	{
		
		List<Developer> devl=developerDao.getAllDeveloper();
		List<Developer>	devL = new ArrayList<Developer>();
		for(Developer d : devl)
		{
			System.out.println("Dev :"+d);
			if(d.getRole().equals("Developer")) {
				
				devL.add(d);

				System.out.println("indside for"+devL.size());
			}
		}
		map.addAttribute("devObj", devL);
		List<ProjectConfiguration> projCon = projectDao.getAllProjectConfig();
		map.addAttribute("projCon", projCon);
		DataEntryOperator dataObj=new DataEntryOperator();
		map.addAttribute("dataObj", dataObj);
		return "MarkAttendance";
	}
	
	@RequestMapping(value="submitData",method=RequestMethod.GET)
	public String attendance(@ModelAttribute(name="dataObj") DataEntryOperator dataObj,ModelMap map)
	{
		boolean saved=developerDao.setAttendance(dataObj);
		if(saved) {
			return "DataEntry";
		}
		else {
			return "MarkAttendance";
		}
	}
}
