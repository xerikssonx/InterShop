package com.shop.inter.dao;

import java.util.List;

import com.shop.inter.entity.Type;

public interface ITypeDao extends IGenericDao<Type> {

	List<Type> getAllTypes();
	
	
}
