package com.shop.inter.dao;

import org.springframework.stereotype.Repository;

import com.shop.inter.entity.User;

@Repository("userDao")
public class UserDao extends GenericDao<User> implements IUserDao {

	@Override
	public User findByUsername(String username) {
		return findEntity(User.FIND_USER_BY_USERNAME, username);
	}

	
}
