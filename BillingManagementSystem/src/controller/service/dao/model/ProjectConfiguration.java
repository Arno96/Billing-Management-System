package controller.service.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="project_config")
public class ProjectConfiguration {
	@Id
	@GeneratedValue
	@Column(name="CONFIGURATION_ID")
	private int CONFIGURATION_ID;
	
	@Column(name="PER_HOUR_BILLING")
	private int PER_HOUR_BILLING;
	
	@Column(name="LOCATION")
	private String LOCATION;
	
	@ManyToOne
	@JoinColumn(name="P_ID")
	Project projectObj;
	
	@ManyToOne
	@JoinColumn(name="ROLE_ID")
	Role roleObj;

	public ProjectConfiguration() {
		super();
	}

	public int getCONFIGURATION_ID() {
		return CONFIGURATION_ID;
	}

	public void setCONFIGURATION_ID(int cONFIGURATION_ID) {
		CONFIGURATION_ID = cONFIGURATION_ID;
	}

	public int getPER_HOUR_BILLING() {
		return PER_HOUR_BILLING;
	}

	public void setPER_HOUR_BILLING(int pER_HOUR_BILLING) {
		PER_HOUR_BILLING = pER_HOUR_BILLING;
	}

	public String getLOCATION() {
		return LOCATION;
	}

	public void setLOCATION(String lOCATION) {
		LOCATION = lOCATION;
	}

	public Project getProjectObj() {
		return projectObj;
	}

	public void setProjectObj(Project projectObj) {
		this.projectObj = projectObj;
	}

	public Role getRoleObj() {
		return roleObj;
	}

	public void setRoleObj(Role roleObj) {
		this.roleObj = roleObj;
	}

	@Override
	public String toString() {
		return "ProjectConfiguration [CONFIGURATION_ID=" + CONFIGURATION_ID + ", PER_HOUR_BILLING=" + PER_HOUR_BILLING
				+ ", LOCATION=" + LOCATION + ", projectObj=" + projectObj + ", roleObj=" + roleObj + "]";
	}
	
}
