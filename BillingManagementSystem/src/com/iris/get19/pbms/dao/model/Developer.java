package com.iris.get19.pbms.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="developer")
public class Developer {

	@Id
	@Column(name="id")
	private int developerId;
	@Column(name="name")
	private String developerName;
	@Column(name="gender")
	private String gender;
	@Column(name="contactno")
	private String contactNo;
	@Column(name="email")
	private String email;
	@Column(name="applicationRole")
	private String role;
	@Column(name="password")
	private String password;
	
	
	public int getDeveloperId() {
		return developerId;
	}
	public void setDeveloperId(int developerId) {
		this.developerId = developerId;
	}
	public String getDeveloperName() {
		return developerName;
	}
	public void setDeveloperName(String developerName) {
		this.developerName = developerName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Developer [developerId=" + developerId + ", developerName=" + developerName + ", gender=" + gender
				+ ", contactNo=" + contactNo + ", email=" + email + ", role=" + role + ", password=" + password + "]";
	}
	
}
