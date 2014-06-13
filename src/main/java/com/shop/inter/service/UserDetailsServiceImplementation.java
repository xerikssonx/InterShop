package com.shop.inter.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.shop.inter.entity.Role;



@Service("userDetailsServiceImpl")
public class UserDetailsServiceImplementation implements UserDetailsService {

	@Autowired
	IUserService userService;

	/**
	 * check user data
	 * 
	 * @param username
	 * @return org.springframework.security.core.userdetails.User Object
	 */
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		com.shop.inter.entity.User user = userService
				.findByUsername(username);		
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		Role role = user.getRole();
		authorities.add(new SimpleGrantedAuthority(role.getName().name()));
		return new User(user.getUsername(), user.getPassword(), true, true,
				true, true, authorities);
	}

}
