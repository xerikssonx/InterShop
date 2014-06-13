package com.shop.inter.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "inter_order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@Column(name = "date")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date date;

	public enum PayType {
		cash, noncash, credits
	}

	@Enumerated(EnumType.STRING)
	private PayType payType;

	public enum DeliveryType {
		courier, post
	}

	@Enumerated(EnumType.STRING)
	private DeliveryType deliveryType;

	// @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	// @JoinTable(name = "inter_OrderToBasket", joinColumns = { @JoinColumn(name
	// = "order_id") }, inverseJoinColumns = { @JoinColumn(name = "basket_id")
	// })
	// private Set<Basket> baskets;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "inter_OrderToProduct", joinColumns = { @JoinColumn(name = "order_id") }, inverseJoinColumns = { @JoinColumn(name = "product_id") })
	private Set<Product> products;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public PayType getPayType() {
		return payType;
	}

	public void setPayType(PayType payType) {
		this.payType = payType;
	}

	public DeliveryType getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(DeliveryType deliveryType) {
		this.deliveryType = deliveryType;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	// public Set<Basket> getBaskets() {
	// return baskets;
	// }
	//
	// public void setBaskets(Set<Basket> baskets) {
	// this.baskets = baskets;
	// }

	
}
