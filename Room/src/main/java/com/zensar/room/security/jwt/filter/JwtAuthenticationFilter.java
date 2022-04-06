package com.zensar.room.security.jwt.filter;

import java.io.IOException;
import java.util.Base64;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.zensar.room.db.TokenStorage;
import com.zensar.room.security.jwt.util.JwtUtil;

public class JwtAuthenticationFilter extends BasicAuthenticationFilter {

	private String AUTHORIZATIONHEADER = "Authorization";
	private final String BEARER = "Bearer ";

	public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		JwtUtil jwtUtil = new JwtUtil();

		System.out.println("IN do filter internal");
		String authorizationHeaderValue = request.getHeader(AUTHORIZATIONHEADER);
		if (authorizationHeaderValue == null || !authorizationHeaderValue.startsWith(BEARER)) {
			chain.doFilter(request, response);
			return;
		}

		String token = authorizationHeaderValue.substring(7);
		String tokenExists = TokenStorage.getToken(token);
		if (tokenExists == null) {
			chain.doFilter(request, response);
			return;
		}
		if (authorizationHeaderValue != null && authorizationHeaderValue.startsWith(BEARER)) {

			try {
				String encodedPayload = jwtUtil.validateToken(token);

				String payload = new String(Base64.getDecoder().decode(encodedPayload));

				JsonParser jsonParser = JsonParserFactory.getJsonParser();
				Map<String, Object> parseMap = jsonParser.parseMap(payload);
				String email = (String) parseMap.get("email");

				UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email,
						null, AuthorityUtils.createAuthorityList("USER"));

				SecurityContextHolder.getContext().setAuthentication(authenticationToken);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		chain.doFilter(request, response);
	}
}
