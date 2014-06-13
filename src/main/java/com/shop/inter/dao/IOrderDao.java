package com.shop.inter.dao;

import java.util.List;

import com.shop.inter.entity.Order;
import com.shop.inter.entity.User;

public interface IOrderDao extends IGenericDao<Order>{
	List<Order> getUsersOrder(User user);
}
