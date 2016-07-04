package com.startsmart.model.dao.daomanagers;

import java.util.List;

import com.startsmart.model.entities.Product;

public interface ProductDao {

	public Integer createProduct(Product product);

	public Product getProductById(int productId);

	public List<Product> getAllActiveProducts();

	public List<Product> getAllProducts();

	public void updateProduct(Product product);

	public void deleteProduct(int productId);
}
