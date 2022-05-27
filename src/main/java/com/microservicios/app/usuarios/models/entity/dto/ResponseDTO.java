package com.microservicios.app.usuarios.models.entity.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseDTO {

	private int responseCode;
	private String description;
	private ResultDTO result;

	public ResponseDTO(int responseCode, String description, ResultDTO result) {
		this.responseCode = responseCode;
		this.description = description;
		this.result = result;
	}
}