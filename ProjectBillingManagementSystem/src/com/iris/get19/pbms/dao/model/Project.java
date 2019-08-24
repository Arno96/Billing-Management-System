package com.iris.get19.pbms.dao.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Project {
	
	
	
	@Id
	private int projectid;
	private  String projectname;
	private String description;
	private char active;
	public int getProjectid() {
		return projectid;
	}
	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}
	public String getProjectname() {
		return projectname;
	}
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public char getActive() {
		return active;
	}
	public void setActive(char active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "Project [projectid=" + projectid + ", projectname=" + projectname + ", description=" + description
				+ ", active=" + active + "]";
	}
}
