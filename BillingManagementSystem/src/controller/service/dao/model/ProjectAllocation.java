package controller.service.dao.model;


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
	private int allocationId;
	
	@OneToOne
	@JoinColumn(name="CONFIG_ID")
	ProjectConfiguration pcObj;
	
	@OneToOne
	@JoinColumn(name="DEV_ID")
	Developer dObj;
	
	public ProjectAllocation() {
		super();
	}

	public int getallocationId() {
		return allocationId;
	}

	public void setallocationId(int allocationId) {
		this.allocationId = allocationId;
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
		return "ProjectAllocation [allocationId=" + allocationId + ", pcObj=" + pcObj + ", dObj=" + dObj + "]";
	}
	
	
	
}
