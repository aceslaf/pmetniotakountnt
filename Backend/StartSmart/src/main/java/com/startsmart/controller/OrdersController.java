package com.startsmart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.startsmart.model.dao.OrderDao;
import com.startsmart.model.pojo.Order;

@Controller
public class OrdersController {

	@Autowired
	OrderDao orderDao;

	@RequestMapping(value = "/order/create", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void createNewOrder(@RequestBody Order order) {
		orderDao.createOrder(order);
	}
/*
	@RequestMapping(value = "/order/{orderId}", method = RequestMethod.GET)
	@ResponseBody
	public Order getOrderById(@PathVariable int orderId) {
		return orderDao.getOrderById(orderId);
	}*/

	@RequestMapping(value = "/order/all", method = RequestMethod.GET)
	@ResponseBody
	public List<Order> getAllOrders() {
		List<Order> allOrders = null;
		allOrders = orderDao.getAllOrders();
		return allOrders;
	}

	@RequestMapping(value = "/order/allActive", method = RequestMethod.GET)
	@ResponseBody
	public List<Order> getAllActiveOrders() {
		List<Order> activeOrders = null;
		activeOrders = orderDao.getAllActiveOrders();
		return activeOrders;
	}

	@RequestMapping(value = "/order/update", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void updateOrder(@RequestBody Order order) {
		orderDao.updateOrder(order);
	}

	@RequestMapping(value = "/order/delete/{orderId}", method = RequestMethod.GET)
	@ResponseBody
	public void deleteOrder(@PathVariable int orderId) {
		orderDao.deleteOrder(orderId);
	}

	@MessageMapping("/order")
	@SendTo("/queue/orders/2")
    public String makeOrder(@RequestBody String a) throws Exception {
		return a;
    }
}
