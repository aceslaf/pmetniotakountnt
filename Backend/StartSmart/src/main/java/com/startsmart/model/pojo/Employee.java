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

@Entity(name = "EMPLOYEES")
@Cacheable(true)
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Employee {

	@JsonProperty("EMPLOYEE_ID")
	@Id
	@GeneratedValue
	@Column(name = "EMPLOYEE_ID")
	private int id;

	@JsonProperty("FIRST_NAME")
	@Column(name = "FIRST_NAME")
	private String firstName;

	@JsonProperty("LAST_NAME")
	@Column(name = "LAST_NAME")
	private String lastName;

	@JsonProperty("USERNAME")
	@Column(name = "USERNAME")
	private String username;

	@JsonProperty("PASSWORD")
	@Column(name = "PASSWORD")
	private String password;

	@JsonProperty("ROLE_ID")
	@Column(name = "ROLE_ID")
	private int roleId;

	@JsonProperty("EMPLOYEE_RIGHTS")
	@Column(name = "EMPLOYEE_RIGHTS")
	private long employeeRights;

	private Timestamp created;
	private Timestamp updated;

	@JsonProperty("STATUS")
	@Column(name = "STATUS")
	private int employeeStatus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getEmployeeStatus() {
		return employeeStatus;
	}

	public void setEmployeeStatus(int status) {
		this.employeeStatus = status;
	}

	public long getEmployeeRights() {
		return employeeRights;
	}

	public void setEmployeeRights(long employeeRights) {
		this.employeeRights = employeeRights;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Timestamp getUpdated() {
		return updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}
}
