package com.startsmart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.startsmart.model.dao.daomanagers.EmployeeDao;
import com.startsmart.model.entities.Employee;

import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeesController {

	@Autowired
	EmployeeDao employeeDao;

	@RequestMapping(value = "/employee/create", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void createNewEmployee(@RequestBody Employee employee) {
		employeeDao.createEmployee(employee);
	}

	@RequestMapping(value = "/employee/{employeeId}", method = RequestMethod.GET)
	@ResponseBody
	public Employee getEmployeeById(@PathVariable int employeeId) {
		Employee employee = null;
		employee = employeeDao.getEmployee(employeeId);
		return employee;
	}

	/* This controller is for authentication and gets the user id injected by the authentication manager*/
	
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	@ResponseBody
	public Employee getEmployeeByUsernameAndPassword(UsernamePasswordAuthenticationToken employee) {
		return employeeDao.getEmployee(Integer.parseInt(employee.getName()));
	}

	@RequestMapping(value = "/employee/all", method = RequestMethod.GET)
	@ResponseBody
	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	@RequestMapping(value = "/employee/allActive", method = RequestMethod.GET)
	@ResponseBody
	public List<Employee> getAllActiveEmployees() {
		return employeeDao.getAllActiveEmployees();
	}

	@RequestMapping(value = "/employee/update", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void updateUserRole(@RequestBody Employee employee) {
		employeeDao.updateEmployee(employee);
	}

	@RequestMapping(value = "/employee/delete/{employeeId}", method = RequestMethod.GET)
	@ResponseBody
	public void deleteEmployee(@PathVariable int employeeId) {
		employeeDao.deleteEmployee(employeeId);
	}
}