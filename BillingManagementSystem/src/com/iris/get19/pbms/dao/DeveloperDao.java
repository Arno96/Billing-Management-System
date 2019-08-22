package com.iris.get19.pbms.dao;

import java.util.List;

import com.iris.get19.pbms.dao.model.DataEntryOperator;
import com.iris.get19.pbms.dao.model.Developer;
import com.iris.get19.pbms.dao.model.ProjectAllocation;

import java.util.List;



public interface DeveloperDao {
	public List<Developer> getAllDeveloper();
	public List<Developer> getAll();
	public Developer getDeveloper(int id,String pass);
	public boolean setProjectConfig(ProjectAllocation obj);
	public boolean setAttendance(DataEntryOperator obj);
	public DataEntryOperator getBill(int id,String month);
}
