package com.aditi.insight.auth.jwt;

import java.util.Collection;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.aditi.insight.utils.GlobalConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserAuthentication extends AbstractAuthenticationToken {

	private static final long serialVersionUID = -385321577604935626L;

	private Object credentials;
	private Object principal;

	private User user;
	private boolean authenticated = true;

	public UserAuthentication(User user) {
		super(null);
		this.user = user;
	}

	public UserAuthentication(Object principal, Object credentials) {

		super(null);
		this.principal = principal;
		this.credentials = credentials;

	}

	@Override
	public String getName() {
		return getPrincipal().toString();
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return AuthorityUtils.createAuthorityList(GlobalConstants.NORMAL_USER_ROLE);
	}

	@Override
	@JsonIgnore
	public Object getCredentials() {
		if (this.credentials != null)
			return this.credentials;
		else
			return this.user.getPassword();
	}

	@Override
	@JsonIgnore
	public User getDetails() {
		return user;
	}

	@Override
	public Object getPrincipal() {
		if (this.principal != null)
			return this.principal;
		else
			return this.user.getUsername();
	}

	@Override
	public boolean isAuthenticated() {
		return authenticated;
	}

	@Override
	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}
}