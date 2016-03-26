package com.startsmart.model.pojo;

public class Role {

	private int roleId;
	private String roleName;
	private String roleStatus;
	private Right[] rights;

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

	public Right[] getRights() {
		return rights;
	}

	public void setRights(Right[] rights) {
		this.rights = rights;
	}

	public String getRoleStatus() {
		return roleStatus;
	}

	public void setRoleStatus(String roleStatus) {
		this.roleStatus = roleStatus;
	}
}
