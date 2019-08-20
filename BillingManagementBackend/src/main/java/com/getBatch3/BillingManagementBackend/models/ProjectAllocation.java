package com.getBatch3.BillingManagementBackend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="project_allocation")
public class ProjectAllocation {
	@Id
	@GeneratedValue
	@Column(name="ALLOCATION_ID")
	private int ALLOCATION_ID;
	
	@OneToOne
	@JoinColumn(name="CONFIG_ID")
	ProjectConfiguration pcObj;
	
	@OneToOne
	@JoinColumn(name="DEV_ID")
	Developer dObj;
	
	public ProjectAllocation() {
		super();
	}

	public int getALLOCATION_ID() {
		return ALLOCATION_ID;
	}

	public void setALLOCATION_ID(int aLLOCATION_ID) {
		ALLOCATION_ID = aLLOCATION_ID;
	}

	public ProjectConfiguration getPcObj() {
		return pcObj;
	}

	public void setPcObj(ProjectConfiguration pcObj) {
		this.pcObj = pcObj;
	}

	public Developer getdObj() {
		return dObj;
	}

	public void setdObj(Developer dObj) {
		this.dObj = dObj;
	}

	@Override
	public String toString() {
		return "ProjectAllocation [ALLOCATION_ID=" + ALLOCATION_ID + ", pcObj=" + pcObj + ", dObj=" + dObj + "]";
	}
	
	
	
}
