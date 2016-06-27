package com.startsmart.model.dto.messagemodels;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RoleMM {

	@JsonProperty("roleId")
	private int roleId;

	@JsonProperty("roleName")
	private String roleName;

	@JsonProperty("roleRights")
	private long rights;
	
	private Timestamp created;
	private Timestamp modified;
	private int roleStatus;

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

	public long getRights() {
		return rights;
	}

	public void setRights(long rights) {
		this.rights = rights;
	}

	public int getRoleStatus() {
		return roleStatus;
	}

	public void setRoleStatus(int roleStatus) {
		this.roleStatus = roleStatus;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Timestamp getModified() {
		return modified;
	}

	public void setModified(Timestamp modified) {
		this.modified = modified;
	}

}
