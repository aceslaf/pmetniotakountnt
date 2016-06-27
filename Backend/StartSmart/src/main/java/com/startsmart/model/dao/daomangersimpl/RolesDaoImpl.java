package com.startsmart.model.dao.daomangersimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.startsmart.model.dao.daomanagers.RoleDao;
import com.startsmart.model.entities.Role;
import com.startsmart.model.hibernate.StartSmartSessionFactory;


@Component
public class RolesDaoImpl implements RoleDao {

	@Autowired
	private StartSmartSessionFactory sessionFactory;

	@Override
	public void createRole(Role role) {
		sessionFactory.getSession().save(role);
	}

	@Override
	public Role getRoleById(int roleId) {
		sessionFactory.getSession().beginTransaction();
		final Role role = (Role) sessionFactory.getSession().get(Role.class, roleId);
		sessionFactory.getSession().getTransaction().commit();
		return role;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Role> getAllRoles() {
		String hql = "from ROLES";
		sessionFactory.getSession().beginTransaction();
		final List<Role> roles = (List<Role>) sessionFactory.getSession().createQuery(hql).list();
		sessionFactory.getSession().getTransaction().commit();
		return roles;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Role> getAllActiveRoles() {
		String hql = "from ROLES where STATUS = 1";
		sessionFactory.getSession().beginTransaction();
		final List<Role> roles = (List<Role>) sessionFactory.getSession().createQuery(hql).list();
		sessionFactory.getSession().getTransaction().commit();
		return roles;
	}

	@Override
	public void updateRole(Role role) {
		sessionFactory.getSession().update(role);
	}

	@Override
	public void deleteRole(int roleId) {
		Role role = new Role();
		role.setRoleId(roleId);
		sessionFactory.getSession().delete(role);
	}

}