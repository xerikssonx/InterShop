package com.shop.inter.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "inter_user")
@NamedQueries({

	@NamedQuery(name = User.FIND_USER_BY_USERNAME, query = User.FIND_USER_BY_USERNAME_QUERY),
	@NamedQuery(name = User.FIND_USER_BY_USERNAME_OR_EMAIL, query = User.FIND_USER_BY_USERNAME_OR_EMAIL_QUERY) })
public class User  {

	public static final String FIND_USER_BY_USERNAME = "User.findByUsername";
	public static final String FIND_USER_BY_USERNAME_QUERY = "FROM User WHERE username LIKE ?1";

	public static final String FIND_USER_BY_USERNAME_OR_EMAIL = "User.findByUsernameOrEmail";
	public static final String FIND_USER_BY_USERNAME_OR_EMAIL_QUERY = "FROM User WHERE username LIKE ?1 OR email LIKE ?2";
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Column(unique = true, name = "username", length = 255)
	private String username;

	@Column(name = "name", length = 255)
	private String name;

	@Column(name = "surname", length = 255)
	private String surname;

	@Column(name = "password", length = 255)
	private String password;

	@Column(unique = true, name = "email", length = 255)
	private String email;

	@Column(name = "phone", length = 255)
	private String phone;

	@Column(name = "city", length = 255)
	private String city;

	@Column(name = "street", length = 255)
	private String street;

	@Column(name = "house", length = 255)
	private String house;

	@Column(name = "room", length = 255)
	private String room;

	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	public Set<Basket> baskets;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}
	public Set<Basket> getBaskets() {
		return baskets;
	}
	public void setBaskets(Set<Basket> baskets) {
		this.baskets = baskets;
	}
	
	

}
