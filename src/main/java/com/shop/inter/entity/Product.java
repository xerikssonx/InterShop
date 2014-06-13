package com.shop.inter.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "inter_product")
@NamedQueries({
		@NamedQuery(name = Product.FIND_BY_TYPE, query = Product.FIND_BY_TYPE_QUERY),
		@NamedQuery(name = Product.FIND_BY_TYPE_AND_SUBTYPE, query = Product.FIND_BY_TYPE_AND_SUBTYPE_QUERY),
		@NamedQuery(name = Product.FIND_ALL, query = Product.FIND_ALL_QUERY) })
public class Product {

	public static final String FIND_BY_TYPE = "Product.findByType";
	public static final String FIND_BY_TYPE_QUERY = "FROM Product where type.name LIKE ?1";

	public static final String FIND_BY_TYPE_AND_SUBTYPE = "Product.findByTypeAndSubType";
	public static final String FIND_BY_TYPE_AND_SUBTYPE_QUERY = "FROM Product where type.name LIKE ?1 and subtype.name LIKE ?2";

	public static final String FIND_ALL = "Product.findAll";
	public static final String FIND_ALL_QUERY = "FROM Product";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "name", length = 255)
	private String name;

	@Column(name = "price")
	private Double price;

	@Column(name = "store_amount")
	private Integer storeAmount;

	@Column(name = "short_description")
	private String shortDescription;

	@Column(name = "description")
	private String description;

	@Column(name = "image", length = 255)
	private String image;

	@ManyToOne
	@JoinColumn(name = "type_id")
	private Type type;

	@ManyToOne
	@JoinColumn(name = "sub_type_id")
	private Subtype subtype;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "inter_OrderToProduct", joinColumns = { @JoinColumn(name = "product_id") }, inverseJoinColumns = { @JoinColumn(name = "order_id") })
	private Set<Order> orders;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getStoreAmount() {
		return storeAmount;
	}

	public void setStoreAmount(Integer storeAmount) {
		this.storeAmount = storeAmount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Subtype getSubtype() {
		return subtype;
	}

	public void setSubtype(Subtype subtype) {
		this.subtype = subtype;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

}
