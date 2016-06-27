package com.startsmart.model.dto.messagemodels;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductMM {

	@JsonProperty("productId")
	private int productId;

	@JsonProperty("productName")
	private String productName;

	@JsonProperty("productPrice")
	private int productPrice;

	@JsonProperty("productWeight")
	private int productWeight;

	@JsonProperty("productOrigin")
	private String productOrigin;

	@JsonProperty("productDescription")
	private String productDescription;

	private Timestamp create;
	private Timestamp modified;
	private int productStatus;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductOrigin() {
		return productOrigin;
	}

	public void setProductOrigin(String productDealer) {
		this.productOrigin = productDealer;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public int getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(int productStatus) {
		this.productStatus = productStatus;
	}

	public int getProductWeight() {
		return productWeight;
	}

	public void setProductWeight(int productWeight) {
		this.productWeight = productWeight;
	}

	public Timestamp getCreate() {
		return create;
	}

	public void setCreate(Timestamp create) {
		this.create = create;
	}

	public Timestamp getModified() {
		return modified;
	}

	public void setModified(Timestamp modified) {
		this.modified = modified;
	}
}
