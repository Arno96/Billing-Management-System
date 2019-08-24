package com.iris.get19.pbms.dao.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DeveloperRole {

	@Id
	private int roleId;
	private String roleName;
	
	
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + "]";
	}

	
}
