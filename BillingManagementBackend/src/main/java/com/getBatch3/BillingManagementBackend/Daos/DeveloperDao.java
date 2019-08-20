package com.getBatch3.BillingManagementBackend.Daos;

import java.util.List;

import com.getBatch3.BillingManagementBackend.models.Developer;
import com.getBatch3.BillingManagementBackend.models.ProjectAllocation;

public interface DeveloperDao {
	public List<Developer> getAllDeveloper();
	public Developer getDeveloper(int id,String pass);
	public boolean setProjectConfig(ProjectAllocation obj);
}
