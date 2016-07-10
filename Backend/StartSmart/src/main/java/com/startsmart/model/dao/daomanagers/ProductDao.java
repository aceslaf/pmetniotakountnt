package com.startsmart.model.dao.daomanagers;

import java.util.List;

import com.startsmart.model.dto.messagemodels.ProductMM;
import com.startsmart.model.entities.Product;

public interface ProductDao {

	public Product createProduct(ProductMM product);

	public Product getProductById(int productId);

	public List<Product> getAllActiveProducts();

	public List<Product> getAllProducts();

	public void updateProduct(ProductMM product);

	public void deleteProduct(int productId);
}
