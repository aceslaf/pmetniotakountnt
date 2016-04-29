package com.startsmart.model.dao;

import java.util.List;

import com.startsmart.model.pojo.OrderItem;

public interface OrderItemDao {

	void createOrderItem(OrderItem orderItem);

	List<OrderItem> getOrderItemsByOrderId(int orderId);

	void updateOrderItem(OrderItem orderItem);

	void deleteOrderItem(int orderItemId);
}
