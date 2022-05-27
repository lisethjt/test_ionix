package com.microservicios.app.usuarios.models.entity.dto;

import lombok.Data;

@Data
public class ResultClientDTO {

	private int registerCount;

	public ResultClientDTO(int registerCount) {
		this.registerCount = registerCount;
	}
}