package com.startsmart.model.dto.messagemodels;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderItemMM {
	
	@JsonProperty("orderItemId")
	private int orderItemId;
	
	@JsonProperty("orderId")
	private int orderId;
	
	@JsonProperty("productId")
	private int productId;
	
	@JsonProperty("itemQuality")
	private double itemQuantity;
	
	@JsonProperty("productPrice")
	private double productPrice;
	
	private Timestamp created;
	private Timestamp modified;	
	private int status;

	public int getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int itemId) {
		this.productId = itemId;
	}
	public double getItemQuantity() {
		return itemQuantity;
	}
	public void setItemQuantity(double itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double itemPrice) {
		this.productPrice = itemPrice;
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

}
