package com.shop.inter.dao;

import java.util.List;

import com.shop.inter.entity.Product;

public interface IProductDao extends IGenericDao<Product> {
	List<Product> findProductByType(String type);

	List<Product> findProductByTypeAndSubtype(String type, String subtype);

	List<Product> findAll();
}
