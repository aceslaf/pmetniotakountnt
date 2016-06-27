package com.startsmart.model.dao.daomangersimpl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.startsmart.model.dao.daomanagers.EmployeeDao;
import com.startsmart.model.entities.Employee;
import com.startsmart.model.hibernate.StartSmartSessionFactory;

@Component
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private StartSmartSessionFactory sessionFactory;

	@Override
	public void createEmployee(Employee employee) {
		sessionFactory.getSession().beginTransaction();
		sessionFactory.getSession().save(employee);
		sessionFactory.getSession().getTransaction().commit();
	}

	public Employee getEmployee(int id) {
		sessionFactory.getSession().beginTransaction();
		Employee employee = (Employee) sessionFactory.getSession().get(Employee.class, id);
		sessionFactory.getSession().getTransaction().commit();
		return employee;
	}

	@Override
	public Employee getEmployeeByUsername(String username) {
		String hql = "from EMPLOYEES e where e.username = :username";
		sessionFactory.getSession().beginTransaction();
		Query query = sessionFactory.getSession().createQuery(hql);
		query.setString("username", username);
		Employee employee = (Employee) query.uniqueResult();
		sessionFactory.getSession().getTransaction().commit();
		return employee; 
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Employee> getAllActiveEmployees() {
		String hql = "from EMPLOYEES where not STATUS = 1";
		sessionFactory.getSession().beginTransaction();
		final List<Employee> employee = (List<Employee>) sessionFactory.getSession().createQuery(hql).list();
		sessionFactory.getSession().getTransaction().commit();
		return employee;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees() {
		String hql = "from EMPLOYEES";
		sessionFactory.getSession().beginTransaction();
		final List<Employee> employee = (List<Employee>) sessionFactory.getSession().createQuery(hql).list();
		sessionFactory.getSession().getTransaction().commit();
		return employee;
	}

	@Override
	public void updateEmployee(Employee employee) {
		sessionFactory.getSession().beginTransaction();
		sessionFactory.getSession().update(employee);
		sessionFactory.getSession().getTransaction().commit();
	}

	@Override
	public void deleteEmployee(int userId) {

		Employee employee = new Employee();
		employee.setId(userId);
		sessionFactory.getSession().beginTransaction();
		sessionFactory.getSession().delete(employee);
		sessionFactory.getSession().getTransaction().commit();
	}
}