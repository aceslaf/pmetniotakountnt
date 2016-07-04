package com.startsmart.model.entities;

import java.sql.Timestamp;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.startsmart.model.dto.messagemodels.EmployeeMM;

@Entity(name = "EMPLOYEES")
@Cacheable(true)
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Employee {

	@Id
	@GeneratedValue
	@Column(name = "EMPLOYEE_ID")
	private int id;
	
	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "USERNAME")
	private String username;

	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "ROLE_ID")
	private int roleId;
	
	@Column(name = "EMPLOYEE_RIGHTS")
	private long employeeRights;

	@Column(name = "CREATED")
	private Timestamp created;
	
	@Column(name = "MODIFIED")
	private Timestamp modified;
	
	@Column(name = "STATUS")
	private int employeeStatus;
	
	public Employee(EmployeeMM employee) {
		this.id = employee.getId();
		this.username = employee.getUsername();
		this.password = employee.getPassword();
		this.firstName = employee.getFirstName();
		this.lastName = employee.getLastName();
		this.roleId = employee.getRoleId();
		this.employeeStatus = employee.getEmployeeStatus();
		this.employeeRights = employee.getEmployeeRights();
	}
	
	public Employee() {
		
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
		return modified;
	}

	public void setUpdated(Timestamp modified) {
		this.modified = modified;
	}
}
