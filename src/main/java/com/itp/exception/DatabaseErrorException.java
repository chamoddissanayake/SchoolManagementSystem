package com.itp.exception;

public class DatabaseErrorException extends Exception{

	private static final long serialVersionUID = 1L;

	public DatabaseErrorException(String string, Object e) {
		super(string);
	}
}
