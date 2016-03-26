package com.startsmart.model.dao;

import java.sql.SQLException;

import com.startsmart.model.pojo.Role;

public interface RoleDao {

	public Role getRoleById(int roleId) throws SQLException;

	public void insertRole(Role role) throws SQLException;

	public void deleteRole(int roleId) throws SQLException;

	public void deleteRole(Role role) throws SQLException;

	public void modifyRole(int roleId) throws SQLException;
	
	public void insertRights(int roleId, int[] rights) throws SQLException;
	
	public void deleteRights(int roleId, int[] rights) throws SQLException;
}
