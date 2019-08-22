package controller.service.dao.impl;

import java.util.List;

import controller.service.dao.model.*;

public interface DeveloperDao {
	public List<Developer> getAllDeveloper();
	public List<Developer> getAll();
	public Developer getDeveloper(int id,String pass);
	public boolean setProjectConfig(ProjectAllocation obj);
	public boolean setAttendance(DataEntryOperator obj);
}
