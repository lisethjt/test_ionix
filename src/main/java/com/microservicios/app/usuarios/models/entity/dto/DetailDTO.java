package com.microservicios.app.usuarios.models.entity.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DetailDTO {

	private String email;
	private String phoneNumber;

	public DetailDTO(String email, String phoneNumber) {
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

}