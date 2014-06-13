package com.shop.inter.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "inter_type")
@NamedQueries({
		@NamedQuery(name = Type.FIND_ALL_TYPES, query = Type.FIND_ALL_TYPES_QUERY),
		@NamedQuery(name = Type.FIND_BY_NAME, query = Type.FIND_BY_NAME_QUERY) })
public class Type {

	public static final String FIND_ALL_TYPES = "Type.findAllTypes";
	public static final String FIND_ALL_TYPES_QUERY = "FROM Type";

	public static final String FIND_BY_NAME = "Type.findByName";
	public static final String FIND_BY_NAME_QUERY = "FROM Type WHERE name LIKE ?1";

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

	@Column(name = "description", length = 255)
	private String description;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "type")
	public Set<Subtype> subtypes;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Subtype> getSubtypes() {
		return subtypes;
	}

	public void setSubtypes(Set<Subtype> subtypes) {
		this.subtypes = subtypes;
	}

}
