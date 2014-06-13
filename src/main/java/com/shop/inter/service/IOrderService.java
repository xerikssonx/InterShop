package com.shop.inter.service;

import java.util.List;
import java.util.Set;

import com.shop.inter.entity.Basket;
import com.shop.inter.entity.Product;

public interface IOrderService {

	double getTotalPrice(List<Basket> baskets);

	void doBuy(String basketList, String payType, String deliveryType,
			String username);

	List<Product> getAllUsersProduct(String username);

	
}
