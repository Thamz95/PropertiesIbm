package com.aditi.insight.auth.jwt;

import org.joda.time.DateTime;
import org.springframework.security.core.userdetails.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public final class TokenHandler {

	private final AuthUserDetailsService userService;

	private final String secret;

	public TokenHandler(String secret, AuthUserDetailsService authUserDetailsService) {
		this.secret = secret;
		this.userService = authUserDetailsService;
	}

	public User parseUserFromToken(String token) {
		String username = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
		return userService.loadUserByUsername(username);
	}

	public String createTokenForUser(User user) {
		return createTokenForUser(user, 720);
	}

	public String createTokenForUser(User user, Integer tokenValidityInHrs) {
		return Jwts.builder().setSubject(user.getUsername()).signWith(SignatureAlgorithm.HS512, secret)
				.setExpiration(DateTime.now().plusHours(tokenValidityInHrs).toDate()).compact();
	}
}
