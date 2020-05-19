package com.walgreens.azure.exception;

public class KeyNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6891781731826545882L;
	
	public KeyNotFoundException(String key) {
		super(key);
	}
	
	

}
