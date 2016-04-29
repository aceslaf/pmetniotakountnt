package com.startsmart.model.dao;

import java.util.List;

import com.startsmart.model.pojo.Product;

public interface ProductDao {

	public void createProduct(Product product);

	public Product getProductById(int productId);

	public List<Product> getAllActiveProducts();

	public List<Product> getAllProducts();

	public void updateProduct(Product product);

	public void deleteProduct(int productId);
}
