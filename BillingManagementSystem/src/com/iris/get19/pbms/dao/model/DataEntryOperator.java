package com.iris.get19.pbms.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="DevAttendance")
public class DataEntryOperator {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int dataEntryOperatorId;
	
	@Column(name="month")
	private String month;
	
	@Column(name="year")
	private int year;

	@Column(name="fullday")
	private int fullDay;
	
	@Column(name="halfday")
	private int halfDay;
	
	@OneToOne
	@JoinColumn(name="devid")
	 Developer devObj;
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getdataEntryOperatorId() {
		return dataEntryOperatorId;
	}

	public void setdataEntryOperatorId(int dataEntryOperatorId) {
		this.dataEntryOperatorId = dataEntryOperatorId;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getfullDay() {
		return fullDay;
	}

	public void setfullDay(int fullDay) {
		this.fullDay = fullDay;
	}

	public int gethalfDay() {
		return halfDay;
	}

	public void sethalfDay(int halfDay) {
		this.halfDay = halfDay;
	}

	public Developer getDevObj() {
		return devObj;
	}

	public void setDevObj(Developer devObj) {
		this.devObj = devObj;
	}


	
	
	
}
