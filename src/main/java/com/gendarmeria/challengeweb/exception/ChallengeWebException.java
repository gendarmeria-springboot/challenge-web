package com.gendarmeria.challengeweb.exception;

import org.springframework.http.HttpStatus;

public class ChallengeWebException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private HttpStatus MyError;

	public HttpStatus getMyError() {
		return MyError;
	}

	public ChallengeWebException(String message, HttpStatus myError) {
		super(message);
		this.MyError = myError;
	}
}
