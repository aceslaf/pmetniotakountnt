package com.startsmart.model.dao.daomanagers;

import java.util.List;

import com.startsmart.model.entities.OrderItem;

public interface OrderItemDao {

	void createOrderItem(OrderItem orderItem);

	List<OrderItem> getOrderItemsByOrderId(int orderId);

	void updateOrderItem(OrderItem orderItem);

	void deleteOrderItem(int orderItemId);
}
