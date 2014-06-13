package com.shop.inter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.inter.dao.IProductDao;
import com.shop.inter.entity.Product;

@Service("productService")
public class ProductService implements IProductService {

	@Autowired
	IProductDao productDao;

	@Override
	public List<Product> findProductByType(String type) {
		return productDao.findProductByType(type);
	}

	@Override
	public List<Product> findProductByTypeAndSubtype(String type, String subtype) {
		return productDao.findProductByTypeAndSubtype(type, subtype);
	}

	@Override
	public List<Product> findAll() {
		return productDao.findAll();
	}

	@Override
	public Product findById(Long id) {
		return productDao.findById(Product.class, id);
	}

}
