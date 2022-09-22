package com.github.kwesidev.restapp.exceptions;

public class ClientNotFoundException extends RuntimeException {

	public ClientNotFoundException() {
		super("Client Not Found ");
	}
}
