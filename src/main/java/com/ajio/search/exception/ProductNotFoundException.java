package com.ajio.search.exception;

public class ProductNotFoundException extends RuntimeException
{
	public ProductNotFoundException(String message)
	{
		super(message);
	}
}
