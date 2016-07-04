package com.startsmart.model.entities;

import java.sql.Timestamp;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.startsmart.model.dto.messagemodels.ProductMM;

@Entity(name = "PRODUCTS")
@Cacheable(true)
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Product {

	@Id
	@GeneratedValue
	@Column(name = "PRODUCT_ID")
	private int productId;

	@Column(name = "PRODUCT_NAME")
	private String productName;

	@Column(name = "PRODUCT_PRICE")
	private int productPrice;

	@Column(name = "PRODUCT_WEIGHT")
	private int productWeight;

	@Column(name = "PRODUCT_ORIGIN")
	private String productOrigin;

	@Column(name = "PRODUCT_DESCRIPTION")
	private String productDescription;
	
	@Column(name = "PRODUCT_TYPE")
	private int productType;

	@Column(name = "CREATED")
	private Timestamp create;
	
	@Column(name = "MODIFIED")
	private Timestamp modified;

	@Column(name = "PRODUCT_STATUS")
	private int productStatus;
	
	public Product() {
		
	}
	
	public Product(ProductMM messageModel) {
		this.productId = messageModel.getProductId();
		this.productName = messageModel.getProductName();
		this.productPrice = messageModel.getProductPrice();
		this.productWeight = messageModel.getProductWeight();
		this.productOrigin = messageModel.getProductOrigin();
		this.productDescription = messageModel.getProductDescription();
		this.productType = messageModel.getProductType();
		this.productStatus = messageModel.getProductStatus();
	}

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

	public int getProductType() {
		return productType;
	}

	public void setProductType(int productType) {
		this.productType = productType;
	}
}