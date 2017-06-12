package com.shop.inter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "inter_basket")
// @NamedQueries({ @NamedQuery(name = Basket.FIND_BACKET_BY_USER, query =
// Basket.FIND_BACKET_BY_USER_QUERY) })
public class Basket {
	// public static final String FIND_BACKET_BY_USER = "Basket.findByUser";
	// public static final String FIND_BACKET_BY_USER_QUERY =
	// "FROM Basket as b inner join User as u WHERE u.id LIKE ?1";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "amount")
	private Integer amount;

	@Column(name = "total_cost")
	private Double totalCost;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	// public Set<Order> getOrders() {
	// return orders;
	// }
	//
	// public void setOrders(Set<Order> orders) {
	// this.orders = orders;
	// }

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
