package com.startsmart.model.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.startsmart.model.dao.RoleDao;
import com.startsmart.model.dao.dbmanager.DBConnection;
import com.startsmart.model.pojo.Role;

@Component
public class RolesDaoImpl implements RoleDao {
	
	@Autowired
	private DBConnection dbConnection;

	@Override
	public Role getRoleById(int roleId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertRole(Role role) throws SQLException {
		String sql = "INSERT INTO ROLES VALUES(?, ? ,?)";
		PreparedStatement preparedStatement = dbConnection.getInstance().prepareStatement(sql);
		preparedStatement.setInt(1, role.getRoleId());
		preparedStatement.setString(2, role.getRoleName());
		preparedStatement.setString(3, role.getRoleStatus());
		preparedStatement.execute();
	}

	@Override
	public void deleteRole(int roleId) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRole(Role role) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyRole(int roleId) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertRights(int roleId, int[] rights) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRights(int roleId, int[] rights) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
