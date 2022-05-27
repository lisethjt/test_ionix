package com.microservicios.app.usuarios.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.microservicios.app.usuarios.models.entity.dto.Response;

@ControllerAdvice
public class ErrorHandlerController {

	@ExceptionHandler({ UserException.class })
	public ResponseEntity<Response> usuarioNoPermitido(Exception ex, WebRequest webRequest) {
		return new ResponseEntity<Response>(new Response(ex.getMessage()), HttpStatus.BAD_REQUEST);
	}
}