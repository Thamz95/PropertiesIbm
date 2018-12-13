package com.aditi.insight.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aditi.insight.domain.User;
import com.aditi.insight.dto.models.RestResponse;
import com.aditi.insight.dto.models.UserDTO;
import com.aditi.insight.exception.InsightException;
import com.aditi.insight.service.UserService;
import com.aditi.insight.utils.ErrorHandler;
import com.aditi.insight.utils.SuccessHandler;

/**
 * SignUp Controller
 *
 */
@RestController
public class SignUpController {

	@Autowired
	private UserService userService;

	/*****************
	 * To signup user*
	 *****************
	 * @param userDTO
	 * @return
	 * @throws InsightException
	 */
	@RequestMapping(value = "api/v1/signUp/user", method = RequestMethod.POST)
	public RestResponse createUser(@RequestBody UserDTO userDTO) throws InsightException {
		User user = userService.addUser(userDTO);
		if (user != null)
			return new RestResponse(true, SuccessHandler.USER_ADDED_SUCCESS, SuccessHandler.ADD_SUCCESS);
		else
			return new RestResponse(false, ErrorHandler.USER_ADD_FAILED, ErrorHandler.ADD_FAILED);
	}
}
