package com.shop.inter.service;

import java.util.List;

import com.shop.inter.entity.Basket;
import com.shop.inter.exception.ProductException;

public interface IBasketService {

	void addProductToBasket(Long productId, Integer amount, String username)
			throws ProductException;

	List<Basket> findAllBasket(String username);

	void deleteBasketsFromUser(String ids);

	List<Basket> findBasketsById(String ids);
}
