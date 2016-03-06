package org.gjoko.javabrains.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

public class HibernateDaoImpl {

	private LocalSessionFactoryBean localSessionFactoryBean;

	public int getCircleCount() {
		String hql = "SELECT COUNT(*) FROM circle";
		Query query = getSessionFactory().getObject().getCurrentSession().createQuery(hql);
		return ((Integer) query.uniqueResult()).intValue();
	}

	public LocalSessionFactoryBean getSessionFactory() {
		return localSessionFactoryBean;
	}

	public void setSessionFactory(LocalSessionFactoryBean localSessionFactoryBean) {
		this.localSessionFactoryBean = localSessionFactoryBean;
	}
}
