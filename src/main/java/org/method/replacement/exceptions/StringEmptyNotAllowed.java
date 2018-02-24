package org.method.replacement.exceptions;

public class StringEmptyNotAllowed extends RuntimeException {

	private static final long serialVersionUID = -8943822852643519517L;
	
	public StringEmptyNotAllowed(String message) {
		super(message);
	}

}
