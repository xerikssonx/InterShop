package com.shop.inter.dao;

import com.shop.inter.entity.User;

public interface IUserDao extends IGenericDao<User> {

	User findByUsername(String username);

	
}
