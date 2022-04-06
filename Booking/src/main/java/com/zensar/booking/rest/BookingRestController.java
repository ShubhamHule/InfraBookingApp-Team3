package com.zensar.booking.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.booking.bean.Booking;
import com.zensar.booking.bean.LoginResponse;
import com.zensar.booking.bean.LoginUser;
import com.zensar.booking.db.TokenStorage;
import com.zensar.booking.security.jwt.util.JwtUtil;
import com.zensar.booking.service.BookingService;

@RestController
public class BookingRestController {

	@Autowired
	BookingService service;

	@Autowired
	private AuthenticationManager manager;

	@Autowired
	private JwtUtil util;

	@PostMapping("/user/authenticate")
	public LoginResponse login(@RequestBody LoginUser user) {
		UsernamePasswordAuthenticationToken authenticationToken;
		authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());

		try {
			manager.authenticate(authenticationToken);
			String token = util.generateToken(user.getUserName());
			TokenStorage.storeToken(token, token);
			LoginResponse userResponse = new LoginResponse();
			userResponse.setJwt(token);
			return userResponse;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	@PostMapping("/booking")
	public ResponseEntity<Booking> addBooking(@RequestBody Booking booking) {
		return new ResponseEntity<Booking>(this.service.addBooking(booking), HttpStatus.CREATED);
	}
}
