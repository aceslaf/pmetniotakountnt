package com.startsmart.model.entities;

import java.sql.Timestamp;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name = "ORDERS")
@Cacheable(true)
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Order {

	@JsonProperty("ORDER_ID")
	@Id
	@GeneratedValue
	@Column(name = "ORDER_ID")
	private int orderId;

	@JsonProperty("PAYMENT_TYPE")
	@Column(name = "PAYMENT_TYPE")
	private int paymentType;

	@JsonProperty("EMPLOYEE_ID")
	@Column(name = "EMPLOYEE_ID")
	private int employeeId;

	@JsonProperty("TOTAL_COST")
	@Column(name = "TOTAL_COST")
	private double totalCost;

	@JsonProperty("ORDER_ITEMS")
	@Column(name = "ORDER_ITEMS")
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