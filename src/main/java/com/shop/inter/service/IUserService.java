package com.shop.inter.service;

import com.shop.inter.entity.User;
import com.shop.inter.exception.RegistrationException;

public interface IUserService {

	public User findByUsername(String username);

	void saveAndValidNewRegistredUser(User user) throws RegistrationException;
}
