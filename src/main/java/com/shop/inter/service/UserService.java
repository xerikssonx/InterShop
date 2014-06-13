package com.shop.inter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.inter.dao.IRoleDao;
import com.shop.inter.dao.IUserDao;
import com.shop.inter.entity.Role;
import com.shop.inter.entity.User;
import com.shop.inter.exception.RegistrationException;

@Service("userService")
public class UserService implements IUserService {

	@Autowired
	IUserDao userDao;
	@Autowired
	IRoleDao roleDao;

	static StandardPasswordEncoder encoder = new StandardPasswordEncoder();

	@Override
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	@Transactional
	public void saveAndValidNewRegistredUser(User user)
			throws RegistrationException {

		validNewUser(user);

		Role role = roleDao.findEntity(Role.FIND_ROLE_BY_NAME, Role.Name.user);
		if (role == null) {
			role = new Role();
			role.setName(Role.Name.user);
			roleDao.save(role);
			user.setRole(role);
		} else {
			user.setRole(role);
		}
		user.setPassword(encoder.encode(user.getPassword()));
		userDao.save(user);

	}

	@Transactional
	private void validNewUser(User user) throws RegistrationException {
		if (user == null) {

			throw new RegistrationException("Null user");
		}

		if (user.getUsername().isEmpty()) {

			throw new RegistrationException("The username is empty");
		}

		if (user.getEmail().isEmpty()) {

			throw new RegistrationException("The mail is empty");
		}

		if (user.getPassword().isEmpty()) {

			throw new RegistrationException("The password is empty");
		}

		User user1 = userDao.findEntity(User.FIND_USER_BY_USERNAME_OR_EMAIL,
				user.getUsername(), user.getEmail());

		if (user1 != null) {
			if (user.getEmail().equals(user1.getEmail())
					&& user.getUsername().equals(user1.getUsername())) {

				throw new RegistrationException(
						"User with this username and mail exists");
			}

			if (user.getEmail().equals(user1.getEmail())) {

				throw new RegistrationException("User with this mail exists");
			}

			if (user.getUsername().equals(user1.getUsername())) {

				throw new RegistrationException(
						"User with this username exists");
			}

		}

	}

}
