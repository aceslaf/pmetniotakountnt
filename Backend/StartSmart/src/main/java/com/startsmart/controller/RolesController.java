package com.startsmart.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.startsmart.model.dao.RoleDao;
import com.startsmart.model.pojo.Role;

public class RolesController {

	@Autowired
	RoleDao roleDao;

	@RequestMapping(value = "/insertNewRole", method = RequestMethod.POST)
	public void createNewEmployee(@RequestBody Role role) {

		try {
			roleDao.insertRole(role);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
