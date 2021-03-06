package com.startsmart.model.dao.daomanagers;

import java.util.List;

import com.startsmart.model.entities.Role;


public interface RoleDao {

	public void createRole(Role role);

	public Role getRoleById(int roleId);

	public List<Role> getAllRoles();

	public List<Role> getAllActiveRoles();

	public void deleteRole(int roleId);

	public void updateRole(Role role);
}
