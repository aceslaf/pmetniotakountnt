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
	@Column(name = "ID")
	private int id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "PRICE")
	private int price;

	@Column(name = "WEIGHT")
	private int weight;

	@Column(name = "ORIGIN")
	private String origin;

	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "TYPE")
	private int type;
	
	@Column(name = "STATUS")
	private int status;
	
	@Column(name = "THUMBNAIL")
	private String thumbnail;

	@Column(name = "CREATED")
	private Timestamp create;
	
	@Column(name = "MODIFIED")
	private Timestamp modified;

	
	
	public Product() {
		
	}
	
	public Product(ProductMM messageModel) {
		this.id = messageModel.getId();
		this.name = messageModel.getName();
		this.price = messageModel.getPrice();
		this.weight = messageModel.getWeight();
		this.origin = messageModel.getOrigin();
		this.description = messageModel.getDescription();
		this.type = messageModel.getType();
		this.status = messageModel.getStatus();
		this.thumbnail = messageModel.getThumbnail();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
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