package com.shop.inter.service;

import java.util.List;

import com.shop.inter.entity.Product;

public interface IProductService {
	List<Product> findProductByType(String type);

	List<Product> findProductByTypeAndSubtype(String type, String subtype);

	List<Product> findAll();

	Product findById(Long id);

}
