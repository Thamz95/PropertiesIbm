package com.aditi.insight.utils;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.aditi.insight.dto.models.RestResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ErrorHandler {

	public static final String ID_NOT_EXIST = "id_not_exist";

	public static final String DTO_CAN_NOT_EMPTY = "Dto can not be empty";

	public static final String DTO_CAN_NOT_NULL = "Dto_can_not_be_empty";

	public static final String ADD_FAILED = "add_failed";

	public static final String UPDATE_FAILED = "update_failed";

	public static final String DELETE_FAILED = "Delete_Failed";

	public static final String USER_NOT_UPDATED = "User data updation failed";

	public static final String PHONE_REQUIRED = "Mobile Number Required";

	public static final String PHONE_MISSING = "Mobile_Number_Missing";

	public static final String PHONE_ALREADY_EXIST = "Mobile Already Exist";

	public static final String PHONE_EXIST = "Mobile_Exist";

	public static final String EMAIL_REQUIRED = "Email Required";

	public static final String EMAIL_ALREADY_EXIST = "Email Already Exist";

	public static final String EMAIL_EXIST = "Email_Exist";

	public static final String EMAIL_CAN_NOT_NULL = "Email_can_not_be_null_or_empty";

	public static final String PASSWORD_REQUIRED = "Password Required";

	public static final String PASSWORD_CAN_NOT_NULL = "Password_can_not_be_null_or_empty";

	private static final String PASSWORD_INCORRECT = "Password incorrect";

	private static final String AUTH_FAILURE = "Authentication failed";

	public static final String USER_ADD_FAILED = "User not added";

	public static final String USER_DELETE_FAIELD = "User delete failed";

	public static final String LOGIN_USERNAME_MISSING = "Login request missing username";

	public static final String LOGIN_PASSWORD_MISSING = "Login request missing password";

	public static final String USERNAME_MISSING = "Username missing";

	public static final String USERNAME_REQUIRED = "user_name_required";

	public static final String USERNAME_ALREADY_EXIST = "userName already exist";

	public static final String USERNAME_EXIST = "Username_Exist";

	public static final String PASSWORD_MISSING = "Password missing";

	public static final String BAD_CREDENTIAL = "Login Failed. Bad credentials";

	public static final String SERVER_ERROR = "server_error";

	public static final String USER_NOT_FOUND = "user_not_found";

	public static final String PERMISION_DENIED = "permision denied";

	public static final String PERMISION_REQUIRED = "Admin_permission_required";

	public static final String USER_NOT_EXIST = "User not exist";

	public static String resolveAuthError(AuthenticationException authEx) {
		try {
			RestResponse errorResponse;
			if (authEx instanceof UsernameNotFoundException) {
				errorResponse = new RestResponse(false, authEx.getMessage(), ErrorHandler.USER_NOT_EXIST);
			} else if (authEx instanceof BadCredentialsException) {
				errorResponse = new RestResponse(false, authEx.getMessage(), ErrorHandler.PASSWORD_INCORRECT);
			} else {
				errorResponse = new RestResponse(false, authEx.getMessage(), ErrorHandler.AUTH_FAILURE);
			}

			ObjectMapper objectMapper = new ObjectMapper();
			return objectMapper.writeValueAsString(errorResponse);
		} catch (JsonProcessingException jsonEx) {
		}
		return GlobalConstants.SERVER_ERROR;
	}
}
