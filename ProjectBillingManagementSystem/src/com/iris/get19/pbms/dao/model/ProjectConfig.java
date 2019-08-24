package com.iris.get19.pbms.dao.model;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;


@Entity
public class ProjectConfig {
		
		@Id
		@GeneratedValue
		private int configid;
		
		
		@ManyToOne
		@JoinColumn(name="projectid")
		private Project project;
		
		private String location;
		
		private int perHourBilling;
		

		@ManyToOne
		@JoinColumn(name="roleid")
		private DeveloperRole role;


		public int getConfigid() {
			return configid;
		}


		public void setConfigid(int configid) {
			this.configid = configid;
		}


		public Project getProject() {
			return project;
		}


		public void setProject(Project project) {
			this.project = project;
		}


		public String getLocation() {
			return location;
		}


		public void setLocation(String location) {
			this.location = location;
		}


		public int getPerHourBilling() {
			return perHourBilling;
		}


		public void setPerHourBilling(int perHourBilling) {
			this.perHourBilling = perHourBilling;
		}


		public DeveloperRole getRole() {
			return role;
		}


		public void setRole(DeveloperRole role) {
			this.role = role;
		}


		@Override
		public String toString() {
			return "ProjectConfig [configid=" + configid + ", project=" + project + ", location=" + location
					+ ", perHourBilling=" + perHourBilling + ", role=" + role + "]";
		}


		
	
		
}
