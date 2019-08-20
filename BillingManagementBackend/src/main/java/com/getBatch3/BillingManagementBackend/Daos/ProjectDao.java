package com.getBatch3.BillingManagementBackend.Daos;

import java.util.List;

import com.getBatch3.BillingManagementBackend.models.Project;
import com.getBatch3.BillingManagementBackend.models.ProjectConfiguration;

public interface ProjectDao {

		public List<Project> getAllProject();
		public Project getProjectById(String projectId);
		public boolean setProjectConfig(ProjectConfiguration obj);
		public List<ProjectConfiguration> getAllProjectConfig();
}
