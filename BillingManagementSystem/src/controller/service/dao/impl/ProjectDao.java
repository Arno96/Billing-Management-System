package controller.service.dao.impl;

import java.util.List;

import controller.service.dao.model.*;

public interface ProjectDao {

		public List<Project> getAllProject();
		public Project getProjectById(String projectId);
		public boolean setProjectConfig(ProjectConfiguration obj);
		public boolean setProjectAllocate(ProjectAllocation pObj);
		public List<ProjectConfiguration> getAllProjectConfig();
}
