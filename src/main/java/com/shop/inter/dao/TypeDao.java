package com.shop.inter.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.shop.inter.entity.Type;
@Repository("typeDao")
public class TypeDao extends GenericDao<Type> implements ITypeDao {

	@Override
	public List<Type> getAllTypes() {
		return findEntityList(Type.FIND_ALL_TYPES);
	}

	

	
}
