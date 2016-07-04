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

@Entity(name="ORDER_ITEMS")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class OrderItem {

	@Id
	@GeneratedValue
	@Column(name="ORDER_ITEM_ID")
	private int orderItemId;
	
	@Column(name="ORDER_ID")
	private int orderId;
	
	@Column(name="PRODUCT_ID")
	private int productId;
	
	@Column(name="ITEM_QUANTITY")
	private double itemQuantity;
	
	@Column(name="PRODUCT_PRICE")
	private double productPrice;
	
	@Column(name = "CREATED")
	private Timestamp created;
	
	@Column(name = "MODIFIED")
	private Timestamp modified;
	
	@Column(name="STATUS")
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
