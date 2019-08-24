package com.iris.get19.pbms.dao.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class DevAttendance{
	
	
	@Id
	@GeneratedValue
	private int dataEntryId;
			
			
	private String month;
	
	
	@OneToOne
	@JoinColumn(name="id")
	private Developer developer;
	
	
	private int totalNoOfHoursPresent;
	


	public int getDataEntryId() {
		return dataEntryId;
	}

	public void setDataEntryId(int dataEntryId) {
		this.dataEntryId = dataEntryId;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}


	public Developer getDeveloper() {
		return developer;
	}

	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}


	public int getTotalNoOfHoursPresent() {
		return totalNoOfHoursPresent;
	}

	public void setTotalNoOfHoursPresent(int totalNoOfHoursPresent) {
		this.totalNoOfHoursPresent = totalNoOfHoursPresent;
	}

	
}
