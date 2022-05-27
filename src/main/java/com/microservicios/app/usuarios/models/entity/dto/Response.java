package com.microservicios.app.usuarios.models.entity.dto;

import lombok.Getter;
import lombok.Setter;

public class Response {

	@Setter
	@Getter
	private String mensaje;

	public Response(String mensaje) {
		this.mensaje = mensaje;
	}
}