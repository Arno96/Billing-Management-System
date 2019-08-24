package com.iris.get19.pbms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iris.get19.pbms.dao.DevAttendanceDao;
import com.iris.get19.pbms.dao.DeveloperDao;
import com.iris.get19.pbms.dao.model.DevAttendance;
import com.iris.get19.pbms.dao.model.Developer;



@Controller
public class DataEntryController {
	
	
	@Autowired
	DeveloperDao developerDao;
	@Autowired
	DevAttendanceDao dataEntryDao;
	
	@RequestMapping(value = "fillattendance", method = RequestMethod.GET)
	public String fillAttendance(ModelMap map) {
		List<Developer> dList = developerDao.viewDeveloper();
		map.addAttribute("dataEntry",new DevAttendance());
		map.addAttribute("dList", dList);
		
		return "DataEntryAttendance";
		
		
	}
	
	@RequestMapping(value = "addAttendance", method = RequestMethod.GET)
	public String addAttendance(@ModelAttribute("dataEntry") DevAttendance devAttendance ,ModelMap map) {
		
		 dataEntryDao.fillAttendance(devAttendance);
		
		return "DataEntry";
		
		
	}
	
	
	

}
