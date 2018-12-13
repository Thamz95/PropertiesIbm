package com.aditi.insight.exception;

public class InsightException extends Exception {

	private static final long serialVersionUID = 3464233322184780227L;

	protected String errConstant;

	public InsightException(Throwable ex) {
		super(ex);
	}

	public InsightException(String message) {
		super(message);
	}

	public InsightException(String message, String errConstant, Throwable ex) {
		super(message, ex);
		this.errConstant = errConstant;
	}

	public InsightException(String message, Throwable ex) {
		super(message, ex);
	}

	public InsightException(String message, String errConstant) {
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
