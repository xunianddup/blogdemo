package com.xfire.it.blog.server.article.service.impl;

public class NoteNotFoundExceprion extends RuntimeException {

	private static final long serialVersionUID = 6097254206851934116L;

	public NoteNotFoundExceprion() {
		super();
	}

	public NoteNotFoundExceprion(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NoteNotFoundExceprion(String message, Throwable cause) {
		super(message, cause);
	}

	public NoteNotFoundExceprion(String message) {
		super(message);
	}

	public NoteNotFoundExceprion(Throwable cause) {
		super(cause);
	}

 
	
}
