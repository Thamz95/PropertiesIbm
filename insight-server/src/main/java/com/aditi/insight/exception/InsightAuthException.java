package com.aditi.insight.exception;

import org.springframework.security.core.AuthenticationException;

public class InsightAuthException extends AuthenticationException {

	private static final long serialVersionUID = -2317729349964250645L;

	private String errConstant;

	public InsightAuthException(String message, String errConstant, Throwable ex) {
		super(message, ex);
		this.errConstant = errConstant;
	}

	public InsightAuthException(String message, Throwable ex) {
		super(message, ex);
	}

	public InsightAuthException(String message, String errConstant) {
		super(message);
		this.errConstant = errConstant;
	}

	public String getErrConstant() {
		return errConstant;
	}

	public void setErrConstant(String errConstant) {
		this.errConstant = errConstant;
	}
}
