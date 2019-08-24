package com.iris.get19.pbms.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iris.get19.pbms.dao.model.Project;




public interface ProjectDao {
	public List<Project> viewProject();
	public Project getProjectById(int id);
}
