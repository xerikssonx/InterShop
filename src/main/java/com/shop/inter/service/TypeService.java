package com.shop.inter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.inter.dao.ITypeDao;
import com.shop.inter.entity.Type;

@Service("typeService")
public class TypeService implements ITypeService {

	@Autowired
	ITypeDao typeDao;

	@Override
	public List<Type> getAllTypes() {
		return typeDao.getAllTypes();
	}

}
