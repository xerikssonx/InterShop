package com.shop.inter.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.shop.inter.entity.Order;
import com.shop.inter.entity.User;

@Repository("orderDao")
public class OrderDao extends GenericDao<Order> implements IOrderDao {

	@Override
	public List<Order> getUsersOrder(User user) {
		String query = "FROM Order as o WHERE o.user.id = :id";
		Query q = getEntityManager().createQuery(query).setParameter("id",
				user.getId());
		return q.getResultList();
	}

}
