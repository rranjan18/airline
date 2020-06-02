package com.ranjan.airline.config;

public class AirlineRuntimeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String code;

	AirlineRuntimeException(String code, String message) {
		super(message);
		this.code = code;
	}
}
