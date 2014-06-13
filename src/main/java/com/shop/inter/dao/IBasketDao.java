package com.shop.inter.dao;

import java.util.List;

import com.shop.inter.entity.Basket;

public interface IBasketDao extends IGenericDao<Basket> {
	List<Basket> findAllBasket(String username);
}
