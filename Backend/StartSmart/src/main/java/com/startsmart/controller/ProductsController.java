package com.startsmart.controller;

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

import com.startsmart.model.dao.daomanagers.ProductDao;
import com.startsmart.model.dto.messagemodels.ProductMM;
import com.startsmart.model.entities.Product;

@Controller
public class ProductsController {

	@Autowired
	ProductDao productDao;

	@RequestMapping(value = "/product/create", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public Integer createProduct(@RequestBody ProductMM product) {
		Product prod = new Product(product);
		return productDao.createProduct(prod);
	}

	@RequestMapping(value = "/product/{productId}", method = RequestMethod.GET)
	@ResponseBody
	public Product getProductById(@PathVariable int productId) {
		final Product product;
		product = productDao.getProductById(productId);
		return product;
	}

	@RequestMapping(value = "/product/all", method = RequestMethod.GET)
	@ResponseBody
	public List<Product> getAllProducts() {
		final List<Product> allProducts;
		allProducts = productDao.getAllProducts();
		return allProducts;
	}

	@RequestMapping(value = "/product/allActive", method = RequestMethod.GET)
	@ResponseBody
	public List<Product> getAllActiveProducts() {
		final List<Product> allActiveProducts;
		allActiveProducts = productDao.getAllActiveProducts();
		return allActiveProducts;
	}

	@RequestMapping(value = "/product/update", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void updateProduct(@RequestBody Product product) {
		productDao.updateProduct(product);
	}

	@RequestMapping(value = "/product/delete/{productId}", method = RequestMethod.GET)
	@ResponseBody
	public void deleteProduct(@PathVariable int productId) {
		productDao.deleteProduct(productId);
	}
}
