package com.shop.inter.dao;

import org.springframework.stereotype.Repository;

import com.shop.inter.entity.Role;

@Repository("roleDao")
public class RoleDao extends GenericDao<Role> implements IRoleDao {

	

}
