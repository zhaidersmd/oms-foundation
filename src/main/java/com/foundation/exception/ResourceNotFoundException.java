package com.foundation.exception;

import org.springframework.stereotype.Component;

@Component
public class ResourceNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 5602210466117603706L;

	public ResourceNotFoundException() {
		
	}
	
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
}
