package com.startsmart.model.dao.daomangersimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.startsmart.model.dao.daomanagers.ProductDao;
import com.startsmart.model.entities.Product;
import com.startsmart.model.hibernate.StartSmartSessionFactory;


@Component
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private StartSmartSessionFactory sessionFactory;

	@Override
	public void createProduct(Product product) {
		sessionFactory.getSession().save(product);
	}

	@Override
	public Product getProductById(int productId) {
		String hql = "from PRODUCT p where p.PRODUCT_ID = :productId and PRODUCT_STATUS = 1";
		final Product product = (Product) sessionFactory.getSession().createQuery(hql).uniqueResult();
		return product;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Product> getAllActiveProducts() {
		String hql = "from PRODUCTS where PRODUCT_STATUS = 1";
		final List<Product> products = (List<Product>) sessionFactory.getSession().createQuery(hql).list();
		return products;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Product> getAllProducts() {
		String hql = "from PRODUCTS";
		final List<Product> allProducts = (List<Product>) sessionFactory.getSession().createQuery(hql).list();
		return allProducts;
	}

	@Override
	public void updateProduct(Product product) {
		sessionFactory.getSession().update(product);
	}

	@Override
	public void deleteProduct(int productId) {
		Product product = new Product();
		product.setProductId(productId);
		sessionFactory.getSession().delete(product);
	}
}
