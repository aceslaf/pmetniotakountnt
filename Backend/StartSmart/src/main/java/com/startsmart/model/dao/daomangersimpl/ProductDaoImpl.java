package com.startsmart.model.dao.daomangersimpl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.startsmart.model.dao.daomanagers.ProductDao;
import com.startsmart.model.dto.messagemodels.ProductMM;
import com.startsmart.model.entities.Product;
import com.startsmart.model.hibernate.StartSmartSessionFactory;


@Component
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private StartSmartSessionFactory sessionFactory;

	@Override
	public Product createProduct(ProductMM productMM) {
		Product productEntity = new Product(productMM);
		productEntity.setCreate(new Timestamp(new Date().getTime()));
		productEntity.setModified(new Timestamp(new Date().getTime()));
		sessionFactory.getSession().beginTransaction();
		sessionFactory.getSession().save(productEntity);
		sessionFactory.getSession().getTransaction().commit();
		return productEntity;
	}

	@Override
	public Product getProductById(int productId) {
		String hql = "from PRODUCT p where p.PRODUCT_ID = :productId and PRODUCT_STATUS = 1";
		sessionFactory.getSession().beginTransaction();
		final Product product = (Product) sessionFactory.getSession().createQuery(hql).uniqueResult();
		sessionFactory.getSession().getTransaction().commit();
		return product;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Product> getAllActiveProducts() {
		String hql = "from PRODUCTS where PRODUCT_STATUS = 1";
		sessionFactory.getSession().beginTransaction();
		final List<Product> products = (List<Product>) sessionFactory.getSession().createQuery(hql).list();
		sessionFactory.getSession().getTransaction().commit();
		return products;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Product> getAllProducts() {
		String hql = "from PRODUCTS";
		sessionFactory.getSession().beginTransaction();
		final List<Product> allProducts = (List<Product>) sessionFactory.getSession().createQuery(hql).list();
		sessionFactory.getSession().getTransaction().commit();
		return allProducts;
	}

	@Override
	public void updateProduct(ProductMM productMM) {
		Product product = new Product(productMM); 
		sessionFactory.getSession().beginTransaction();
		sessionFactory.getSession().update(product);
		sessionFactory.getSession().getTransaction().commit();
	}

	@Override
	public void deleteProduct(int id) {
		Product product = new Product();
		product.setId(id);
		sessionFactory.getSession().beginTransaction();
		sessionFactory.getSession().delete(product);
		sessionFactory.getSession().getTransaction().commit();
	}
}
