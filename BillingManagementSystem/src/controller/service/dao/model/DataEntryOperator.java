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
@Table(name="Data_entry")
public class DataEntryOperator {

	@Id
	@GeneratedValue
	@Column(name="Data_Id")
	private int dataEntryOperatorId;
	
	@Column(name="month")
	private String month;
	
	@Column(name="full_day")
	private int fullDay;
	
	@Column(name="half_day")
	private int halfDay;
	
	@OneToOne
	@JoinColumn(name="Dev_Id")
	 Developer devObj;
	
	@OneToOne
	@JoinColumn(name="configuration_Id")
	 ProjectConfiguration configObj;

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

	public ProjectConfiguration getConfigObj() {
		return configObj;
	}

	public void setConfigObj(ProjectConfiguration configObj) {
		this.configObj = configObj;
	}

	
	
	
}
