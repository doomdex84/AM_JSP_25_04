package com.koreaIT.java.AM_jsp;


public class SQLErrorException extends RuntimeException {
	private Exception origin;

	public SQLErrorException(String message, Exception origin) {
		super(message);
		this.origin = origin;
	}

	public Exception getOrigin() {
		return origin;
	}
}