package com.xfire.it.blog.server.article.service.impl;

public class NotebookNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2917876900436448909L;

	public NotebookNotFoundException() {
	}

	public NotebookNotFoundException(String message) {
		super(message);
	}

	public NotebookNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public NotebookNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public NotebookNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
