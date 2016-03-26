package com.startsmart.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.startsmart.model.pojo.Employee;

public interface EmployeeDao {
	
	public Employee getEmployeeById(int employeeId) throws SQLException;
	
	public List<Employee> getAllActiveEmployees() throws SQLException;
	
	public void createNewEmplyee(Employee employee) throws SQLException;
	
	public void deleteEmployeeById(int employeeId) throws SQLException;
	
	public void updateRoleOfUser(int employeeId, int roleId) throws SQLException;
}
