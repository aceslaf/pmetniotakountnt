package com.startsmart.model.dao.daomanagers;

import java.util.List;

import com.startsmart.model.dto.messagemodels.OrderMM;
import com.startsmart.model.entities.Order;

public interface OrderDao {
	
	public void createOrder(OrderMM order);
	
	public Order getOrderById(int orderId);
	
	public List<Order> getAllActiveOrders();
	
	public List<Order> getAllOrders();
	
	public void updateOrder(OrderMM order);
	
	public void deleteOrder(int orderId);
}
