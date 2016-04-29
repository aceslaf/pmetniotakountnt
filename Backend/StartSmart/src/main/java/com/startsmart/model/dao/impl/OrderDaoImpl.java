package com.startsmart.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.startsmart.model.dao.OrderDao;
import com.startsmart.model.dao.hibernate.StartSmartSessionFactory;
import com.startsmart.model.pojo.Order;

@Component
public class OrderDaoImpl implements OrderDao {

	@Autowired
	private StartSmartSessionFactory sessionFactory;

	@Override
	public void createOrder(Order order) {
		// TODO implement logic to insert all orderItems after
		sessionFactory.getSession().save(order);
	}

	@Override
	public Order getOrderById(int orderId) {
		String hql = "from ORDERS o where o.ORDER_ID = :orderId";
		Query query = sessionFactory.getSession().createQuery(hql);
		query.setInteger("orderId", orderId);

		// TODO implement logic to take orderItems after orderItemsDao is
		// created

		return (Order) query.uniqueResult();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Order> getAllActiveOrders() {
		String hql = "from ORDERS o WHERE o.STATUS = 1";
		List<Order> orders = (List<Order>) sessionFactory.getSession().createQuery(hql).list();
		return orders;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Order> getAllOrders() {
		String hql = "from ORDERS";
		final List<Order> orders = (ArrayList<Order>) sessionFactory.getSession().createQuery(hql).list();
		return orders;
	}

	@Override
	public void updateOrder(Order order) {
		sessionFactory.getSession().update(order);
	}

	@Override
	public void deleteOrder(int orderId) {
		Order order = new Order();
		order.setOrderId(orderId);
		sessionFactory.getSession().delete(order);
	}
}