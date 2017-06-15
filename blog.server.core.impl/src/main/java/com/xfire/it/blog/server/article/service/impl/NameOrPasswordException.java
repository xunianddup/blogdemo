package com.xfire.it.blog.server.article.service.impl;

public class NameOrPasswordException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6025203304413465870L;
	public static final int NAME=1;
	public static final int PASSWORD=2;
	
	private int field;
	
	public NameOrPasswordException() {
	}
	public NameOrPasswordException(
			int field, String message) {
		super(message);
		this.field = field;
	}
	public NameOrPasswordException(Throwable cause) {
		super(cause);
	}
	public NameOrPasswordException(String message, Throwable cause) {
		super(message, cause);
	}
	public NameOrPasswordException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
	public int getField() {
		return field;
	}

}
