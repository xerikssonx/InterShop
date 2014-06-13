package com.shop.inter.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "inter_Role")
@NamedQueries({

@NamedQuery(name = Role.FIND_ROLE_BY_NAME, query = Role.FIND_ROLE_BY_NAME_QUERY) })
public class Role  {
	
	public static final String FIND_ROLE_BY_NAME = "Role.findByName";
	public static final String FIND_ROLE_BY_NAME_QUERY = "FROM Role WHERE name LIKE ?1";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public enum Name {
		user, admin
	}

	@Enumerated(EnumType.STRING)
	private Name name;

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

}
