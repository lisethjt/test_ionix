package com.microservicios.app.usuarios.exception;

public class UserException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserException() {
		super("Usuario no permitido");
	}
}