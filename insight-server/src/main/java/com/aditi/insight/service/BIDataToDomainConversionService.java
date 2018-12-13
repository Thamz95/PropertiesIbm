package com.aditi.insight.service;

import org.springframework.stereotype.Service;

import com.aditi.insight.domain.User;
import com.aditi.insight.dto.models.UserDTO;



/**
 * Domain to DTO conversion service
 *
 */
@Service
public class BIDataToDomainConversionService {

	/**************************
	 * convert user To userDTO*
	 **************************
	 * @param user
	 * @return
	 */
	public UserDTO convertUser(User user) {

		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setName(user.getName());
		userDTO.setEmail(user.getEmail());
		userDTO.setPassword(user.getPassword());
		userDTO.setMobile(user.getMobile());
		userDTO.setJoinedStatus(user.getJoinedStatus());
		return userDTO;
	}

}
