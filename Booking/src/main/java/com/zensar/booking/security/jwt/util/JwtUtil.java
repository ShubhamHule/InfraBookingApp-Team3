package com.zensar.booking.security.jwt.util;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

@Component
public class JwtUtil {

	private final String SECRET_KEY = "zensar@123";

	public String generateToken(String email) {

		String token = JWT.create().withClaim("email", email)
				.withExpiresAt(new Date(System.currentTimeMillis() + 1800000)).sign(Algorithm.HMAC512(SECRET_KEY));
		return token;
	}

	public String validateToken(String token) {
		return JWT.require(Algorithm.HMAC512(SECRET_KEY)).build().verify(token).getPayload();
	}
}
