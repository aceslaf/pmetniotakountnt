package com.startsmart.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import com.startsmart.model.dao.EmployeeDao;
import com.startsmart.model.pojo.Employee;

@Controller
public class EmployeesController {

	@Autowired
	EmployeeDao employeeDao;

	@RequestMapping(value = "/getEmployeeById/{employeeId}", method = RequestMethod.GET)
	@ResponseBody
	public Employee getEmployeeById(@PathVariable int employeeId) {

		Employee employee = null;
		try {
			employee = employeeDao.getEmployeeById(employeeId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}

	@RequestMapping(value = "/getAllActiveEmployees", method = RequestMethod.GET)
	@ResponseBody
	public List<Employee> getAllActiveEmployees() {
		
		List<Employee> activeEmployees = null;
		try {
			activeEmployees = employeeDao.getAllActiveEmployees();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return activeEmployees;
	}

	@RequestMapping(value = "/insertNewEmployee", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void createNewEmployee(@RequestBody Employee employee) {

		try {
			employeeDao.createNewEmplyee(employee);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/updateEmloyeeRole/{employeeId}/{roleId}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public void updateUserRole(@PathVariable int employeeId, @PathVariable int roleId) {
		
		try {
			employeeDao.updateRoleOfUser(employeeId, roleId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}