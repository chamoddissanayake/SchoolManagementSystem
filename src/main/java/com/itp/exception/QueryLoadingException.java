package com.itp.exception;

public class QueryLoadingException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public QueryLoadingException(String string, Exception e) {
		super(string,e);
	}

	public QueryLoadingException(String string) {
		super(string);
	}
}
