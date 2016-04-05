package com.startsmart.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.startsmart.model.dao.ProductDao;
import com.startsmart.model.pojo.Product;

@Controller
public class ProductController {

	@Autowired
	ProductDao productDao;
	
	@RequestMapping(value = "/product/create", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void createProduct(@RequestBody Product product) {

		try {
			productDao.createProduct(product);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/product/{productId}", method = RequestMethod.GET)
	@ResponseBody
	public Product getProductById(@PathVariable int productId) {

		Product product = null;
		try {
			product = productDao.getProductById(productId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}

	@RequestMapping(value = "/product/all", method = RequestMethod.GET)
	@ResponseBody
	public List<Product> getAllProducts() {
		
		List<Product> allProducts = null;
		try {
			allProducts = productDao.getAllProducts();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allProducts;
	}
	
	@RequestMapping(value = "/product/allActive", method = RequestMethod.GET)
	@ResponseBody
	public List<Product> getAllActiveProducts() {
		
		List<Product> allActiveProducts = null;
		try {
			allActiveProducts = productDao.getAllActiveProducts();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allActiveProducts;
	}
	
	@RequestMapping(value = "/product/update", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void updateProduct(@RequestBody Product product) {
		
		try {
			productDao.updateProduct(product);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/product/delete/{productId}", method = RequestMethod.GET)
	@ResponseBody
	public void deleteProduct(@PathVariable int productId) {
		try {
			productDao.deleteProduct(productId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
