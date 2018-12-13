package com.aditi.insight.auth.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.aditi.insight.dto.models.RestResponse;
import com.aditi.insight.dto.models.UserDTO;
import com.aditi.insight.exception.InsightException;
import com.aditi.insight.service.DataModelToDTOConversionService;
import com.aditi.insight.service.UserService;
import com.aditi.insight.utils.ErrorHandler;
import com.aditi.insight.utils.GlobalConstants;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StatelessLoginFilter extends AbstractAuthenticationProcessingFilter
		implements AuthenticationFailureHandler {

	private final UserService userService;
	private final AuthUserDetailsService userDetailsService;
	private final TokenAuthenticationService tokenAuthenticationService;
	private final DataModelToDTOConversionService dataModelToDTOConversionService;

	protected StatelessLoginFilter(String urlMapping, UserService userService,
			DataModelToDTOConversionService dataModelToDTOConversionService,
			TokenAuthenticationService tokenAuthenticationService, AuthUserDetailsService userDetailsService,
			AuthenticationManager authManager) {

		super(new AntPathRequestMatcher(urlMapping));

		this.userService = userService;
		this.userDetailsService = userDetailsService;
		this.tokenAuthenticationService = tokenAuthenticationService;
		this.dataModelToDTOConversionService = dataModelToDTOConversionService;
		setAuthenticationFailureHandler(this);
		setAuthenticationManager(authManager);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {

		if (request.getParameter(GlobalConstants.USERNAME) == null) {
			throw new AuthenticationServiceException(ErrorHandler.USERNAME_MISSING);
		}
		if (request.getParameter(GlobalConstants.PASSWORD) == null) {
			throw new AuthenticationServiceException(ErrorHandler.PASSWORD_MISSING);
		}

		final UserAuthentication loginToken = new UserAuthentication(
				request.getParameter(GlobalConstants.USERNAME).toLowerCase().toString(),
				request.getParameter(GlobalConstants.PASSWORD).toString());

		return getAuthenticationManager().authenticate(loginToken);
	}

	public void onNotJoined(ServletRequest request, ServletResponse response,
			org.springframework.security.core.AuthenticationException exception) throws IOException, ServletException {

		authFailureResponse(response, exception);
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authentication) throws IOException, ServletException {

		UserAuthentication authenticationToken = (UserAuthentication) authentication;
		final User authenticatedUser = userDetailsService.loadUserByUsername(authenticationToken.getName());
		final UserAuthentication userAuthentication = new UserAuthentication(authenticatedUser);

		// Add the custom token as HTTP header to the response
		tokenAuthenticationService.addAuthentication(response, userAuthentication);

		// Add the authentication to the Security context
		SecurityContextHolder.getContext().setAuthentication(userAuthentication);

		/*
		 * Writing user information to response after successful authentication
		 */
		com.aditi.insight.domain.User user = null;
		try {
			user = userService.getUser(authenticatedUser.getUsername());
		} catch (InsightException e) {
			e.printStackTrace();
		}
		UserDTO userDTO = dataModelToDTOConversionService.convertUser(user);

		RestResponse authStatus = new RestResponse(true, userDTO);
		ObjectMapper mapper = new ObjectMapper();
		String responseObject = mapper.writeValueAsString(authStatus);
		((HttpServletResponse) response).getWriter().append(responseObject);
	}

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		SecurityContextHolder.clearContext();
		String erroMsg = ErrorHandler.resolveAuthError(exception);		
		RestResponse authStatus = new RestResponse(false, erroMsg);
		ObjectMapper mapper = new ObjectMapper();
		String responseObject = mapper.writeValueAsString(authStatus);
		((HttpServletResponse) response).setContentType(MediaType.APPLICATION_JSON_VALUE);
		((HttpServletResponse) response).setStatus(HttpServletResponse.SC_OK);
		((HttpServletResponse) response).getWriter().append(responseObject);		
	}

	private void authFailureResponse(ServletResponse response,
			org.springframework.security.core.AuthenticationException exception) throws IOException {
		SecurityContextHolder.clearContext();

		String erroMsg = ErrorHandler.resolveAuthError(exception);
		((HttpServletResponse) response).setContentType("application/json");
		((HttpServletResponse) response).setStatus(HttpServletResponse.SC_OK);
		((HttpServletResponse) response).getOutputStream().println(erroMsg);
	}
}
