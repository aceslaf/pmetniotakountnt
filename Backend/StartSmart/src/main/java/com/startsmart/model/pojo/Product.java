package com.startsmart.model.pojo;

import java.sql.Timestamp;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Cacheable(true)
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Product {

	@JsonProperty("PRODUCT_ID")
	@Id
	@GeneratedValue
	@Column(name = "PRODUCT_ID")
	private int productId;

	@JsonProperty("PRODUCT_NAME")
	@Column(name = "PRODUCT_NAME")
	private String productName;

	@JsonProperty("PRODUCT_PRICE")
	@Column(name = "PRODUCT_PRICE")
	private int productPrice;

	@JsonProperty("PRODUCT_WEIGHT")
	@Column(name = "PRODUCT_WEIGHT")
	private int productWeight;

	@JsonProperty("PRODUCT_ORIGIN")
	@Column(name = "PRODUCT_ORIGIN")
	private String productOrigin;

	@JsonProperty("PRODUCT_DESCRIPTION")
	@Column(name = "PRODUCT_DESCRIPTION")
	private String productDescription;

	private Timestamp create;
	private Timestamp modified;

	@JsonProperty("PRODUCT_STATUS")
	@Column(name = "PRODUCT_STATUS")
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
