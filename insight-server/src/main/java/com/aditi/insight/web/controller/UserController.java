package com.aditi.insight.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.aditi.insight.domain.User;
import com.aditi.insight.dto.models.RestResponse;
import com.aditi.insight.dto.models.UserDTO;
import com.aditi.insight.exception.InsightException;
import com.aditi.insight.service.DataModelToDTOConversionService;
import com.aditi.insight.service.PageableService;
import com.aditi.insight.service.UserService;
import com.aditi.insight.utils.ErrorHandler;
import com.aditi.insight.utils.SuccessHandler;

/**
 * User Controller
 *
 */
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private DataModelToDTOConversionService dataModelToDTOConversionService;

	@Autowired
	private PageableService pageableService;

	/*****************
	 * To create User*
	 *****************
	 * @param userDTO
	 * @return
	 * @throws InsightException
	 */
	@RequestMapping(value = "/auth/v1/user", method = RequestMethod.POST)
	public RestResponse createUser(@RequestBody UserDTO userDTO) throws InsightException {
		User user = userService.addUser(userDTO);
		if (user != null)
			return new RestResponse(true, SuccessHandler.USER_ADDED_SUCCESS, SuccessHandler.ADD_SUCCESS);
		else
			return new RestResponse(false, ErrorHandler.USER_ADD_FAILED, ErrorHandler.ADD_FAILED);
	}

	/*****************
	 * To update user*
	 *****************
	 * @param id
	 * @param userDTO
	 * @return
	 * @throws InsightException
	 */
	@RequestMapping(value = "/api/v1/user/{id}", method = RequestMethod.PUT)
	public RestResponse updateUser(@PathVariable("id") long id, @RequestBody UserDTO userDTO) throws InsightException {
		User user = userService.updateUser(id, userDTO);
		UserDTO convertedUserDTO = dataModelToDTOConversionService.convertUser(user);
		return new RestResponse(true, convertedUserDTO, SuccessHandler.UPDATE_SUCCESS);
	}

	/**
	 * Delete User API (Only admin can use)
	 * 
	 * @param id
	 * @return
	 * @throws InsightException
	 */
	@RequestMapping(value = "/api/v1/user/{id}", method = RequestMethod.DELETE)
	public RestResponse deleteUser(@PathVariable("id") long id) throws InsightException {
		/*
		 * User user = userService.getLoggedinUser(); if (user.getUserRole() ==
		 * null || !user.getUserRole().equals(GlobalConstants.ADMIN)) throw new
		 * InsightException(ErrorHandler.PERMISION_DENIED,
		 * ErrorHandler.PERMISION_REQUIRED);
		 */
		Boolean isDeleted = userService.deleteUser(id);
		RestResponse response = null;
		if (isDeleted)
			response = new RestResponse(RestResponse.SUCCESS, isDeleted, SuccessHandler.DELETE_SUCCESS);
		else
			response = new RestResponse(RestResponse.FAILED, isDeleted, ErrorHandler.DELETE_FAILED);
		return response;
	}

	/*******************
	 * To get all user**
	 *******************
	 * @param pageNo
	 * @param sortField
	 * @param sortOrder
	 * @return
	 * @throws InsightException
	 */
	@RequestMapping(value = "/api/v1/user", method = RequestMethod.GET)
	public RestResponse getAllUser(@RequestParam(value = "pageNo", required = false) String pageNo,
			@RequestParam(value = "sortField", required = false) String sortField,
			@RequestParam(value = "sortOrder", required = false) String sortOrder) throws InsightException {

		Pageable pageable = pageableService.getPageRequestObject(pageNo, sortField,
				pageableService.getSortDirection(sortOrder));
		/*
		 * User user = userService.getLoggedinUser(); if (user.getUserRole() ==
		 * null || !user.getUserRole().equals(GlobalConstants.ADMIN)) throw new
		 * InsightException(ErrorHandler.PERMISION_DENIED,
		 * ErrorHandler.PERMISION_REQUIRED);
		 */
		Page<User> users = userService.getAllUsers(pageable);
		return new RestResponse(true, users, SuccessHandler.GET_SUCCESS);
	}

	@RequestMapping(value = "/api/v1/logout", method = RequestMethod.POST)
	public RestResponse logout() {
		return new RestResponse(RestResponse.SUCCESS, "Logout successfully");

	}

}
