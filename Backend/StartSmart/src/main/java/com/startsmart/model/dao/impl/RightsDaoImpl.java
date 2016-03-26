package com.startsmart.model.dao.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.startsmart.model.dao.RightDao;
import com.startsmart.model.dao.dbmanager.DBConnection;
import com.startsmart.model.pojo.Right;

@Component
public class RightsDaoImpl implements RightDao {
	
	@Autowired
	private DBConnection dbConnection;

	@Override
	public Right getRightById(int rightId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertNewRight(Right right) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Right modifyRight(int rightId, String rightName) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRight(int rightId) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeRoles(int rightId, int[] roleId) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertRoles(int rightId, int[] roleId) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int[] getRoles(int rightId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
