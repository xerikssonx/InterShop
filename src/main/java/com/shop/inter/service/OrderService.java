package com.shop.inter.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.inter.dao.IBasketDao;
import com.shop.inter.dao.IOrderDao;
import com.shop.inter.dao.IUserDao;
import com.shop.inter.entity.Basket;
import com.shop.inter.entity.Order;
import com.shop.inter.entity.Order.DeliveryType;
import com.shop.inter.entity.Order.PayType;
import com.shop.inter.entity.Product;
import com.shop.inter.entity.User;

@Service("orderService")
public class OrderService implements IOrderService {

	@Autowired
	IUserDao userDao;
	@Autowired
	IBasketService basketService;
	@Autowired
	IBasketDao basketDao;
	@Autowired
	IOrderDao orderDao;

	@Override
	public double getTotalPrice(List<Basket> baskets) {
		double totalPrice = 0;
		for (Basket b : baskets) {
			totalPrice += b.getTotalCost();
		}

		return totalPrice;
	}

	@Override
	@Transactional
	public void doBuy(String basketList, String payType, String deliveryType,
			String username) {
		List<Basket> baskets = basketService.findBasketsById(basketList);
		User user = userDao.findByUsername(username);
		Order order = new Order();
		order.setUser(user);
		order.setDate(new Date());

		Set<Product> products = new HashSet<>();

		switch (payType) {
		case "1":
			order.setPayType(PayType.cash);
			break;
		case "2":
			order.setPayType(PayType.credits);
			break;
		case "3":
			order.setPayType(PayType.noncash);
			break;
		default:
			break;
		}

		switch (deliveryType) {
		case "1":
			order.setDeliveryType(DeliveryType.courier);
			break;
		case "2":
			order.setDeliveryType(DeliveryType.post);
			break;

		default:
			break;
		}

		for (Basket b : baskets) {
			products.add(b.getProduct());
			basketDao.delete(b);
		}
		order.setProducts(products);
		orderDao.save(order);

	}

	@Override
	@Transactional
	public List<Product> getAllUsersProduct(String username) {
		User user = userDao.findByUsername(username);
		List<Order> orderList = orderDao.getUsersOrder(user);
		List<Product> productList = new ArrayList<>();
		for (Order o : orderList) {
			o.getProducts().size();
			productList.addAll(o.getProducts());
		}

		return productList;
	}
}
