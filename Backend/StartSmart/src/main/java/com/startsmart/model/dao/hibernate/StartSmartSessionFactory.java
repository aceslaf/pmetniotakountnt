package com.startsmart.model.dao.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.stereotype.Service;

@Service
public class StartSmartSessionFactory {

	private SessionFactory sessionFactory = null;
	
	
	private StartSmartSessionFactory() {
		sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
}
