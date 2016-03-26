package com.startsmart.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.startsmart.model.dao.EmployeeDao;
import com.startsmart.model.dao.dbmanager.DBConnection;
import com.startsmart.model.pojo.Employee;

@Component
public class EmployeeDaoImpl implements EmployeeDao {

	public EmployeeDaoImpl() {

	}

	@Autowired
	private DBConnection dbConnection;

	public Employee getEmployeeById(int id) throws SQLException {
		String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID=?";
		ResultSet resultSet = null;
		Employee employee = new Employee();
		PreparedStatement preparedStatement = null;
		preparedStatement = dbConnection.getInstance().prepareStatement(sql);
		preparedStatement.setInt(1, id);
		resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			employee.setId(resultSet.getInt(1));
			employee.setFirstName(resultSet.getString(2));
			employee.setLastName(resultSet.getString(3));
			employee.setUsername(resultSet.getString(4));
			employee.setPassword(resultSet.getString(5));
			employee.setRoleId(resultSet.getInt(6));
			employee.setStatus(resultSet.getInt(7));
		}
		return employee;
	}

	public List<Employee> getAllActiveEmployees() throws SQLException {
		String sql = "SELECT * FROM EMPLOYEES";
		ResultSet resultSet = null;
		List<Employee> employees = new ArrayList<>();
		resultSet = dbConnection.getInstance().prepareStatement(sql).executeQuery();
		while (resultSet.next()) {
			Employee employee = new Employee();
			employee.setId(resultSet.getInt(1));
			employee.setFirstName(resultSet.getString(2).trim());
			employee.setLastName(resultSet.getString(3).trim());
			employee.setUsername(resultSet.getString(4).trim());
			employee.setPassword(resultSet.getString(5).trim());
			employee.setRoleId(resultSet.getInt(6));
			employee.setStatus(resultSet.getInt(7));
			employees.add(employee);
		}
		return employees;
	}

	public void createNewEmplyee(Employee employee) throws SQLException {
		String sql = "INSERT INTO EMPLOYEES VALUES (DEFAULT, ?, ?, ?, ?, ?, ?)";

		PreparedStatement preparedStatement = dbConnection.getInstance().prepareStatement(sql);
		preparedStatement.setString(1, employee.getFirstName());
		preparedStatement.setString(2, employee.getLastName());
		preparedStatement.setString(3, employee.getUsername());
		preparedStatement.setString(4, employee.getPassword());
		preparedStatement.setInt(5, employee.getRoleId());
		preparedStatement.setInt(6, employee.getStatus());
		preparedStatement.executeUpdate();
	}

	@Override
	public void deleteEmployeeById(int userId) throws SQLException {
		String sql = "UPDATE EMPLOYEES SET  = false WHERE USER_ID = ?";
		Connection connection = dbConnection.getInstance();
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, userId);
		preparedStatement.executeUpdate();
	}

	@Override
	public void updateRoleOfUser(int userId, int roleId) throws SQLException {
		String sql = "UPDATE EMPLOYEES SET ROLE_ID = ? WHERE EMPLOYEE_ID = ?";
		Connection connection = dbConnection.getInstance();
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, roleId);
		preparedStatement.setInt(2, userId);
		preparedStatement.executeUpdate();
	}

}
