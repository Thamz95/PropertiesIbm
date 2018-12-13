package com.aditi.insight.auth.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.aditi.insight.utils.ErrorHandler;
import com.aditi.insight.utils.GlobalConstants;

public class UserAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private PasswordHashService passwordHashService;

	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		UserAuthentication token = (UserAuthentication) auth;

		String username = (auth.getPrincipal() == null) ? null : auth.getPrincipal().toString();
		String password = (auth.getCredentials() == null) ? null : auth.getCredentials().toString();

		if (username == null)
			throw new UsernameNotFoundException(ErrorHandler.LOGIN_USERNAME_MISSING);

		if (password == null)
			throw new BadCredentialsException(ErrorHandler.LOGIN_PASSWORD_MISSING);

		UserDetails userFromDB = userDetailsService.loadUserByUsername(username);

		if (userFromDB == null)
			throw new UsernameNotFoundException(GlobalConstants.USER_NOT_FOUND_WITH_EMAIL + " '" + username + "'");

		if (!passwordHashService.passwordMatches(password, userFromDB.getPassword())) {
			throw new BadCredentialsException(ErrorHandler.BAD_CREDENTIAL);
		}
		return token;

	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UserAuthentication.class.isAssignableFrom(authentication);
	}

}
