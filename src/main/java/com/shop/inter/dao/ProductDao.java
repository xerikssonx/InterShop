package com.shop.inter.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.shop.inter.entity.Product;

@Repository("productDao")
public class ProductDao extends GenericDao<Product> implements IProductDao {

	@Override
	public List<Product> findProductByType(String type) {
		return findEntityList(Product.FIND_BY_TYPE, type);
	}

	@Override
	public List<Product> findProductByTypeAndSubtype(String type, String subtype) {

		return findEntityList(Product.FIND_BY_TYPE_AND_SUBTYPE, type, subtype);
	}

	@Override
	public List<Product> findAll() {
		return findEntityList(Product.FIND_ALL);
	}

}
