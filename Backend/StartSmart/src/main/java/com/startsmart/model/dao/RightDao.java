package com.startsmart.model.dao;

import java.sql.SQLException;

import com.startsmart.model.pojo.Right;

public interface RightDao {
	public Right getRightById(int rightId) throws SQLException;
	
	public void insertNewRight(Right right) throws SQLException;
	
	public Right modifyRight(int rightId, String rightName) throws SQLException;
	
	public void deleteRight(int rightId) throws SQLException;
	
	public void removeRoles(int rightId, int[] roleId) throws SQLException;
	
	public void insertRoles(int rightId, int[] roleId) throws SQLException;
	
	public int[] getRoles(int rightId) throws SQLException;
}
