package com.startsmart.model.dao.daomangersimpl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.startsmart.model.dao.daomanagers.OrderItemDao;
import com.startsmart.model.entities.OrderItem;
import com.startsmart.model.hibernate.StartSmartSessionFactory;

@Component
public class OrderItemDaoImpl implements OrderItemDao {

	@Autowired
	private StartSmartSessionFactory sessionFactory;

	@Override
	public void createOrderItem(OrderItem orderItem) {
		sessionFactory.getSession().save(orderItem);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<OrderItem> getOrderItemsByOrderId(int orderId) {
		String sql = "from ORDER_ITEMS oi WHERE oi.ORDER_ID = :orderId";
		Query query = sessionFactory.getSession().createQuery(sql);
		query.setInteger("orderId", orderId);
		final List<OrderItem> orderItems = query.list();
		return orderItems;
	}

	@Override
	public void updateOrderItem(OrderItem orderItem) {
		sessionFactory.getSession().update(orderItem);
	}

	@Override
	public void deleteOrderItem(int orderItemId) {
		OrderItem orderItem = new OrderItem();
		orderItem.setOrderItemId(orderItemId);
		sessionFactory.getSession().delete(orderItem);
	}

}
