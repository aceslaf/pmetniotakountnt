package com.startsmart.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.startsmart.model.dao.daomanagers.EmployeeDao;
import com.startsmart.model.entities.Employee;

public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private EmployeeDao employeeDao;

	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee employee = employeeDao.getEmployeeByUsername(username);
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		return buildUserForAuthentication(employee, authorities);
	}

	private User buildUserForAuthentication(Employee employee, List<GrantedAuthority> authorities) {
		return new User(String.valueOf(employee.getId()) , employee.getPassword(), authorities);
	}
}
