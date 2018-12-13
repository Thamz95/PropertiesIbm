package com.aditi.insight.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aditi.insight.auth.jwt.PasswordHashService;
import com.aditi.insight.domain.User;
import com.aditi.insight.dto.models.UserDTO;


/**
 * DTO to Domain conversion service
 *
 */
@Service
public class DTOToDomainConverstionService {

	@Autowired
	private PasswordHashService passwordHashService;

	/**************************
	 * convert UserDTO To User*
	 **************************
	 * @param userDTO
	 * @return
	 */
	public User convertUser(UserDTO userDTO) {

		User user = new User();
		user.setName(userDTO.getName());
		user.setEmail(userDTO.getEmail());
		user.setPassword(passwordHashService.encodePassword(userDTO.getPassword()));
		return user;
	}
}
