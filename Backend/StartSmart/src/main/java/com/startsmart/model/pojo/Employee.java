package com.startsmart.model.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {

	@JsonProperty("EMPLOYEE_ID")
	private int id;

	@JsonProperty("FIRST_NAME")
	private String firstName;

	@JsonProperty("LAST_NAME")
	private String lastName;

	@JsonProperty("USERNAME")
	private String username;

	@JsonProperty("PASSWORD")
	private String password;

	@JsonProperty("ROLE_ID")
	private int roleId;

	@JsonProperty("STATUS")
	private int status;

	public Employee() {

	}

	public Employee(int id, String firstName, String lastName, String username, String password, int roleId,
			int status) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.status = status;
		this.roleId = roleId;
	}

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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
