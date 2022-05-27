package com.microservicios.app.usuarios.models.entity.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ItemDTO {

	private String name;
	private DetailDTO detail;

	public ItemDTO(String name, DetailDTO detail) {
		this.name = name;
		this.detail = detail;
	}
}