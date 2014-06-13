package com.shop.inter.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shop.inter.entity.Basket;
import com.shop.inter.entity.User;

@Repository("basketDao")
public class BasketDao extends GenericDao<Basket> implements IBasketDao {

	@Autowired
	IUserDao userDao;

	@Override
	public List<Basket> findAllBasket(String username) {
		User user = userDao.findEntity(User.FIND_USER_BY_USERNAME, username);
		Query query = getEntityManager().createQuery(
				"FROM Basket AS b WHERE b.user.id = :id").setParameter("id",
				user.getId());
		@SuppressWarnings("unchecked")
		List<Basket> list = query.getResultList();
		return list;
	}
}
