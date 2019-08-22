package controller.service.dao.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="Project")
public class Project {
	
	@Id
	@Column(name="Project_Id")
	private String projectId;
	
	@Column(name="Project_Name")
	private String projectName;
	
	@Column(name="Description")
	private String descprition;
	
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
	
	
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", descprition=" + descprition
				+ "]";
	}
	
	
}
