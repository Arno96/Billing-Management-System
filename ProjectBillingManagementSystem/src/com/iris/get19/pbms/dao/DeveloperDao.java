package com.iris.get19.pbms.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iris.get19.pbms.dao.model.Developer;





public interface DeveloperDao {
	public List<Developer> viewDeveloper();
	public Developer getDeveloperById(int id);
	public boolean validateDeveloper(int id,String password);
	}
