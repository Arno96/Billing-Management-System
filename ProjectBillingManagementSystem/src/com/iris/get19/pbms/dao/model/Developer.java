package com.iris.get19.pbms.dao.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;





@Entity
public class Developer {
	
	@Id
	@NotNull
	private Integer id;
	private String name;
	private String gender;
	private Long contactno;
	private String email;
	private String applicationRole;
	
	
	@NotEmpty(message="please enter your password")
	private String password;
	
	
	
	public Long getContactno() {
		return contactno;
	}
	public void setContactno(Long contactno) {
		this.contactno = contactno;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getApplicationRole() {
		return applicationRole;
	}
	public void setApplicationRole(String applicationRole) {
		this.applicationRole = applicationRole;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Developer [id=" + id + ", name=" + name + ", gender=" + gender + ", contactno=" + contactno + ", email="
				+ email + ", applicationRole=" + applicationRole + ", password=" + password + "]";
	}
	
	
	
	
	
}
