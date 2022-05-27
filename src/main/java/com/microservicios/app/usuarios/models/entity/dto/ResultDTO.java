package com.microservicios.app.usuarios.models.entity.dto;

import java.util.List;

import lombok.Data;

@Data
public class ResultDTO {

	List<ItemDTO> items;
}