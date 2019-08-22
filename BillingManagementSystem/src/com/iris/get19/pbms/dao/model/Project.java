package com.iris.get19.pbms.dao.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="Project")
public class Project {
	
	@Id
	@Column(name="projectid")
	private String projectId;
	
	@Column(name="projectname")
	private String projectName;
	
	@Column(name="description")
	private String descprition;
	
	@Column(name="active")
	private String active;

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getDescprition() {
		return descprition;
	}

	public void setDescprition(String descprition) {
		this.descprition = descprition;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", descprition=" + descprition
				+ ", active=" + active + "]";
	}
	
	
	
}
