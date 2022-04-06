package com.zensar.booking.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.zensar.booking.bean.Employee;
import com.zensar.booking.db.EmployeeDAO;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private EmployeeDAO dao;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		Employee foundUser = dao.findByEmail(email);
		System.out.println(foundUser);
		if (foundUser == null) {
			throw new UsernameNotFoundException(email);
		}

		User authenticatedUser = new User(foundUser.getEmail(), foundUser.getPassword(), foundUser.getRoles());

		return authenticatedUser;
	}

}
