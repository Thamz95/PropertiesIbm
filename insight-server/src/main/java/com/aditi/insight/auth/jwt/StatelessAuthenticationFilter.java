package com.aditi.insight.auth.jwt;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.filter.GenericFilterBean;
import com.aditi.insight.utils.ErrorHandler;
import com.aditi.insight.utils.GlobalConstants;
import com.google.common.base.Preconditions;



public class StatelessAuthenticationFilter extends GenericFilterBean {

	private final TokenAuthenticationService tokenAuthenticationService;

	private RequestMatcher skipAuthenticationRequestMatcher;

	public StatelessAuthenticationFilter(String urlMappingToIgnore,
			TokenAuthenticationService tokenAuthenticationService) {
		skipAuthenticationRequestMatcher = new AntPathRequestMatcher(urlMappingToIgnore);
		this.tokenAuthenticationService = Preconditions.checkNotNull(tokenAuthenticationService);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {

		if (skipAuthenticationRequestMatcher.matches((HttpServletRequest) request)) {
			filterChain.doFilter(request, response); // skip auth and continue
			return;
		}

		try {
			UserAuthentication authentication = (UserAuthentication) tokenAuthenticationService
					.getAuthentication((HttpServletRequest) request);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			filterChain.doFilter(request, response);
		} catch (AuthenticationServiceException authenticationException) {
			
			SecurityContextHolder.clearContext();
			String erroMsg = ErrorHandler.resolveAuthError(authenticationException);
			((HttpServletResponse) response).setContentType(GlobalConstants.CONTENT_TYPE);
			((HttpServletResponse) response).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			((HttpServletResponse) response).getOutputStream().println(erroMsg);
		}
	}
}
