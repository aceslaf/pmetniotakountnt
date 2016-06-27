package com.startsmart.model.dto.messagemodels;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.startsmart.model.entities.OrderItem;

public class OrderMM {

	@JsonProperty("orderId")
	private int orderId;

	@JsonProperty("paymentType")
	private int paymentType;

	@JsonProperty("employeeId")
	private int employeeId;

	@JsonProperty("totalCost")
	private double totalCost;

	@JsonProperty("orderItems")
	private OrderItem[] orderItems;

	private Timestamp created;
	private Timestamp modified;
	private int status;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(int paymentType) {
		this.paymentType = paymentType;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Timestamp getModified() {
		return modified;
	}

	public void setModified(Timestamp modified) {
		this.modified = modified;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public OrderItem[] getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(OrderItem[] orderItems) {
		this.orderItems = orderItems;
	}
}
