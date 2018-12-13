package com.aditi.insight.auth.jwt;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import com.aditi.insight.utils.GlobalConstants;


public class TokenAuthenticationService {

	private TokenHandler tokenHandler;

	@Autowired
	private AuthUserDetailsService authUserDetailsService;

	@Value("${token.handler.secret}")
	private String secret;

	@PostConstruct
	public void init() {
		tokenHandler = new TokenHandler(secret, authUserDetailsService);
	}

	public String addAuthentication(HttpServletResponse response, UserAuthentication authentication) {
		final User user = authentication.getDetails();
		String token = tokenHandler.createTokenForUser(user);
		response.addHeader(GlobalConstants.HEADER_AUTH_TOKEN, token);
		return token;
	}

	public Authentication getAuthentication(HttpServletRequest request) {

		String jwtStringToken = request.getHeader(GlobalConstants.HEADER_AUTH_TOKEN);

		if (jwtStringToken != null) {
			final User user = tokenHandler.parseUserFromToken(jwtStringToken);
			if (user != null) {
				return new UserAuthentication(user);
			}
		}
		throw new AuthenticationServiceException(GlobalConstants.AUTH_TOKEN_HEADER_MISSING);

	}

	public String getAuthTokenForUser(String email, Integer tokenValidityInHrs) {
		User user = authUserDetailsService.loadUserByUsername(email);
		return tokenHandler.createTokenForUser(user, tokenValidityInHrs);
	}
}
