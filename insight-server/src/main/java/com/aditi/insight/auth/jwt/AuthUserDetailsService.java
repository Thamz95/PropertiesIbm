package com.aditi.insight.auth.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.aditi.insight.service.UserService;
import com.aditi.insight.utils.GlobalConstants;

public class AuthUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	public final User loadUserByUsername(String email) throws UsernameNotFoundException {
		com.aditi.insight.domain.User user = null;
		try {
			user = userService.getUser(email);
		} catch (Exception e) {

		}

		if (user == null) {
			throw new UsernameNotFoundException(GlobalConstants.USER_NOT_FOUND_WITH_EMAIL+ " '"  + email + "'");
		}
		try {
			String password = "N/A";
			if (user.getPassword() != null)
				password = user.getPassword();

			User userDetail = new User(user.getEmail(), password,
					AuthorityUtils.createAuthorityList(GlobalConstants.NORMAL_USER_ROLE));
			return userDetail;
		} catch (Exception ex) {
			throw new UsernameNotFoundException(ex.getMessage());
		}
	}

}
