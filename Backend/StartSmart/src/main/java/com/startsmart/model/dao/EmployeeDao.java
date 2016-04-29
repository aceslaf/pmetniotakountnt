package com.startsmart.model.dao;

import java.util.List;

import com.startsmart.model.pojo.Employee;

public interface EmployeeDao {

	public void createEmployee(Employee employee);

	public Employee getEmployee(int employeeId);
	
	public Employee getEmployee(String username, String password);

	public List<Employee> getAllActiveEmployees();

	public List<Employee> getAllEmployees();

	public void updateEmployee(Employee employee);

	public void deleteEmployee(int employeeId);
}
