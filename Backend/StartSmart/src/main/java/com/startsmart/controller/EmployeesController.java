package com.startsmart.controller;

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

	@RequestMapping(value = "/employee/{employeeUsername}/{employeePassword}", method = RequestMethod.GET)
	@ResponseBody
	public Employee getEmployeeByUsernameAndPassword(@PathVariable String employeeUsername,
			@PathVariable String employeePassword) {
		return employeeDao.getEmployee(employeeUsername, employeePassword);
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