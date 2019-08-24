package com.iris.get19.pbms.dao.model;

import java.io.Serializable;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class DevAllocation implements Serializable{
	
	
	@Id
	@OneToOne
	@JoinColumn(name="id")
	private Developer developer;
	
	
	@OneToOne
	@JoinColumn(name="configid")
	private ProjectConfig projectConfig;


	public Developer getDeveloper() {
		return developer;
	}


	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}


	public ProjectConfig getProjectConfig() {
		return projectConfig;
	}


	public void setProjectConfig(ProjectConfig projectConfig) {
		this.projectConfig = projectConfig;
	}


	@Override
	public String toString() {
		return "DevAllocation [developer=" + developer + ", projectConfig=" + projectConfig + "]";
	}


	


	
	
	
		

}
