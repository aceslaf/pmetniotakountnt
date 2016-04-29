package com.startsmart.model.dao;

import java.util.List;

import com.startsmart.model.pojo.Order;

public interface OrderDao {
	
	public void createOrder(Order order);
	
	public Order getOrderById(int orderId);
	
	public List<Order> getAllActiveOrders();
	
	public List<Order> getAllOrders();
	
	public void updateOrder(Order order);
	
	public void deleteOrder(int orderId);
}
