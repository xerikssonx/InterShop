package com.shop.inter.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.inter.dao.IBasketDao;
import com.shop.inter.dao.IProductDao;
import com.shop.inter.dao.IUserDao;
import com.shop.inter.entity.Basket;
import com.shop.inter.entity.Product;
import com.shop.inter.entity.User;
import com.shop.inter.exception.ProductException;

@Service("basketService")
public class BasketService implements IBasketService {

	@Autowired
	IProductDao productDao;
	@Autowired
	IUserDao userDao;
	@Autowired
	IBasketDao basketDao;

	@Override
	@Transactional
	public synchronized void addProductToBasket(Long productId, Integer amount,
			String username) throws ProductException {
		Product product = productDao.findById(Product.class, productId);
		User user = userDao.findEntity(User.FIND_USER_BY_USERNAME, username);
		if (product.getStoreAmount() >= amount) {
			product.setStoreAmount(product.getStoreAmount() - amount);
			Basket basket = new Basket();
			basket.setUser(user);
			basket.setAmount(amount);
			basket.setTotalCost(product.getPrice() * amount);
			basket.setProduct(product);
			productDao.update(product);
			basketDao.save(basket);
		} else {
			throw new ProductException(
					"Sorry, no such quantity of goods in stock");
		}

	}

	@Override
	@Transactional
	public List<Basket> findAllBasket(String username) {

		return basketDao.findAllBasket(username);
	}

	@Override
	@Transactional
	public void deleteBasketsFromUser(String ids) {
		Basket basket;
		Product product;
		long[] mas = parseString(ids);
		for (long L : mas) {
			basket = basketDao.findById(Basket.class, L);
			product = basket.getProduct();
			product.setStoreAmount(product.getStoreAmount()
					+ basket.getAmount());
			productDao.update(product);
			basketDao.delete(basket);

		}

	}

	private long[] parseString(String str) {
		String[] mas = str.split(",");
		long[] masLong = new long[mas.length];
		for (int i = 0; i < masLong.length; i++) {
			masLong[i] = Long.parseLong(mas[i]);
		}

		return masLong;
	}

	@Override
	public List<Basket> findBasketsById(String ids) {
		long[] mas = parseString(ids);
		List<Basket> baskets = new ArrayList<>();
		for (long L : mas) {
			baskets.add(basketDao.findById(Basket.class, L));
		}
		return baskets;
	}
}
