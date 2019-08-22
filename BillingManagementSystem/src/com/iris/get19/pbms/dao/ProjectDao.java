package com.iris.get19.pbms.dao;

import java.util.List;

import com.iris.get19.pbms.dao.model.Project;
import com.iris.get19.pbms.dao.model.ProjectAllocation;
import com.iris.get19.pbms.dao.model.ProjectConfiguration;

public interface ProjectDao {

		public List<Project> getAllProject();
		public Project getProjectById(String projectId);
		public boolean setProjectConfig(ProjectConfiguration obj);
		public boolean setProjectAllocate(ProjectAllocation pObj);
		public List<ProjectConfiguration> getAllProjectConfig();
}
