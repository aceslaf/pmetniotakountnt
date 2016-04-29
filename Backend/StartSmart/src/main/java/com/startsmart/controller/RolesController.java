package com.startsmart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.startsmart.model.dao.RoleDao;
import com.startsmart.model.pojo.Role;

@Controller
public class RolesController {

	@Autowired
	RoleDao roleDao;

	@RequestMapping(value = "/role/new", method = RequestMethod.POST)
	public void createRole(@RequestBody Role role) {
		roleDao.createRole(role);
	}

	@RequestMapping(value = "/role/{roleId}", method = RequestMethod.GET)
	@ResponseBody
	public Role getRoleById(@PathVariable int roleId) {
		final Role role = roleDao.getRoleById(roleId);
		return role;
	}

	@RequestMapping(value = "/role/all", method = RequestMethod.GET)
	@ResponseBody
	public List<Role> getAllRoles() {
		final List<Role> allRoles = roleDao.getAllRoles();
		return allRoles;
	}

	@RequestMapping(value = "/role/allActive", method = RequestMethod.GET)
	@ResponseBody
	public List<Role> getAllActiveRoles() {
		final List<Role> allActiveProducts = roleDao.getAllActiveRoles();
		return allActiveProducts;
	}

	@RequestMapping(value = "/role/update", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void updateRole(@RequestBody Role role) {
		roleDao.updateRole(role);
	}

	@RequestMapping(value = "/role/delete/{roleId}", method = RequestMethod.GET)
	@ResponseBody
	public void deleteRole(@PathVariable int roleId) {
		roleDao.deleteRole(roleId);
	}
}
