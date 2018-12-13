package com.aditi.insight.auth.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.aditi.insight.service.DataModelToDTOConversionService;
import com.aditi.insight.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private AuthUserDetailsService userDetailsService;

	@Autowired
	private UserService userService;

	@Autowired
	private DataModelToDTOConversionService dataModelToDTOConversionService;

	@Autowired
	private TokenAuthenticationService tokenAuthenticationService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public void configure(WebSecurity webSecurity) throws Exception {
		webSecurity.ignoring()
				// All of Spring Security will ignore the requests.
				// '/{[path:[^\\.]*}' is to avoid
				.antMatchers("/").antMatchers("/api/**").antMatchers("/resources/**").antMatchers("/**/*.html").antMatchers("/favicon.ico")
				.antMatchers("/images/**").antMatchers("/").antMatchers("/web/**").antMatchers("/public/**").antMatchers("/pubset/**")
				.antMatchers("/pub/**").antMatchers("/resources/**").antMatchers("/assets/**").antMatchers("/favicon.ico")
				.antMatchers("/**/*.html").antMatchers("/static/**").antMatchers("/app/**").antMatchers("/**/*.css").antMatchers("/**/*.js")
				.antMatchers("/websocket/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().exceptionHandling().and()
				.servletApi().and().authorizeRequests()

				// Allow logins urls
				.antMatchers("/auth/**").permitAll().antMatchers("/api/**").authenticated().and()
				// Custom Token based authentication based on the header
				.addFilterAfter(new StatelessAuthenticationFilter("/auth/**", tokenAuthenticationService),
						UsernamePasswordAuthenticationFilter.class)
				.addFilterBefore(new StatelessLoginFilter("/auth/login", userService, dataModelToDTOConversionService,
						tokenAuthenticationService, userDetailsService, authenticationManager), StatelessAuthenticationFilter.class)
				.headers().cacheControl().and();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(createUserAuthenticationProvider()).userDetailsService(userDetailsService())
				.passwordEncoder(new BCryptPasswordEncoder());
	}

	@Bean
	@Override
	public AuthUserDetailsService userDetailsService() {
		this.userDetailsService = new AuthUserDetailsService();
		return userDetailsService;
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public AuthenticationProvider createUserAuthenticationProvider() {
		return new UserAuthenticationProvider();
	}

	@Bean
	public TokenAuthenticationService tokenAuthenticationService() {
		this.tokenAuthenticationService = new TokenAuthenticationService();
		return tokenAuthenticationService;
	}
}
