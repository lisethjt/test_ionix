package com.microservicios.app.usuarios.models.entity.dto;

import lombok.Data;

@Data
public class ResponseClientDTO {

	private int responseCode;
	private String description;
	private int elapsedTime;
	private ResultClientDTO result;

	public ResponseClientDTO(int responseCode, String description, int elapsedTime, ResultClientDTO result) {
		this.responseCode = responseCode;
		this.description = description;
		this.elapsedTime = elapsedTime;
		this.result = result;
	}
}