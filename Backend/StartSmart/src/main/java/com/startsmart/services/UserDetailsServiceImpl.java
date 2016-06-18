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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.startsmart.model.dao.EmployeeDao;
import com.startsmart.model.pojo.Employee;

@Service("userDetailsService")
@Transactional(readOnly = true)
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	EmployeeDao employeeDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee employee = employeeDao.getEmployeeByUsername(username);
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		return buildUserForAuthentication(employee, authorities);
	}
	
	private UserDetails buildUserForAuthentication(Employee employee, List<GrantedAuthority> authorities) {
		User user = new User(String.valueOf(employee.getId()), employee.getPassword(), authorities);
		return user;
	}
}
