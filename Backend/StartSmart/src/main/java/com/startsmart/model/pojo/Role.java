package com.startsmart.model.pojo;

import java.sql.Timestamp;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name = "ROLES")
@Cacheable(true)
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Role {

	@JsonProperty("ROLE_ID")
	@Id
	@GeneratedValue
	@Column(name = "ROLE_ID")
	private int roleId;

	@JsonProperty("ROLE_NAME")
	@Column(name = "ROLE_NAME")
	private String roleName;

	@JsonProperty("ROLE_RIGHTS")
	@Column(name = "ROLE_RIGHTS")
	private long rights;
	
	
	@Column(name="CREATED")
	private Timestamp created;
	
	@Column(name="MODIFIED")
	private Timestamp modified;

	@JsonProperty("STATUS")
	@Column(name = "STATUS")
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
