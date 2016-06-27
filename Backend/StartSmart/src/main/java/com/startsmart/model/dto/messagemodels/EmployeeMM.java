package com.startsmart.model.dto.messagemodels;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeMM {
	
	@JsonProperty("id")
	private int id;
	
	@JsonProperty("firstName")
	private String firstName;
	
	@JsonProperty("lastName")
	private String lastName;
	
	@JsonProperty("username")
	private String username;
	
	@JsonProperty("password")
	private String password;
	
	@JsonProperty("roleId")
	private int roleId;
	
	@JsonProperty("emoloyeeRights")
	private long employeeRights;
	
	@JsonProperty("employeeStatus")
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public long getEmployeeRights() {
		return employeeRights;
	}

	public void setEmployeeRights(long employeeRights) {
		this.employeeRights = employeeRights;
	}

	public int getEmployeeStatus() {
		return employeeStatus;
	}

	public void setEmployeeStatus(int employeeStatus) {
		this.employeeStatus = employeeStatus;
	}
}