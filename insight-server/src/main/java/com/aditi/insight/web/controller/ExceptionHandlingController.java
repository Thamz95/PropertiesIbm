package com.aditi.insight.web.controller;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import com.aditi.insight.dto.models.RestResponse;
import com.aditi.insight.exception.InsightAuthException;
import com.aditi.insight.exception.InsightException;
import com.aditi.insight.utils.ErrorHandler;



@ControllerAdvice
public class ExceptionHandlingController {

	public final Logger logger = LoggerFactory.getLogger(ExceptionHandlingController.class);

	
	@ExceptionHandler(InsightException.class)
	@ResponseBody
	public ResponseEntity<Object> handleError(HttpServletRequest req, InsightException ex) {
		RestResponse errorResponse = new RestResponse(RestResponse.FAILED, ex.getMessage(), ex.getErrConstant());
		return new ResponseEntity<Object>(errorResponse, HttpStatus.OK);
	}
	
	@ExceptionHandler(AuthenticationException.class)
	@ResponseBody
	public ResponseEntity<Object> handleAuthenticationError(HttpServletRequest req, InsightException ex) {
		RestResponse errorResponse = new RestResponse(RestResponse.FAILED, ex.getMessage(), ex.getErrConstant());
		return new ResponseEntity<Object>(errorResponse, HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ResponseEntity<Object> handleError(HttpServletRequest req, Exception ex) {
		RestResponse errorResponse = new RestResponse(RestResponse.FAILED, ex.getMessage(), ErrorHandler.SERVER_ERROR);
		return new ResponseEntity<Object>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(InsightAuthException.class)
	@ResponseBody
	public ResponseEntity<Object> handleAuthError(HttpServletRequest req, InsightException ex) {
		RestResponse errorResponse = new RestResponse(RestResponse.FAILED, ex.getMessage(), ex.getErrConstant());
		return new ResponseEntity<Object>(errorResponse, HttpStatus.UNAUTHORIZED);
	}
}