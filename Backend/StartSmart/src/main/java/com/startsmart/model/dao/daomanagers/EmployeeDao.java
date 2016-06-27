package com.startsmart.model.dao.daomanagers;

import java.util.List;

import com.startsmart.model.entities.Employee;

public interface EmployeeDao {

	public void createEmployee(Employee employee);

	public Employee getEmployee(int employeeId);
	
	public Employee getEmployeeByUsername(String username);

	public List<Employee> getAllActiveEmployees();

	public List<Employee> getAllEmployees();

	public void updateEmployee(Employee employee);

	public void deleteEmployee(int employeeId);
}
