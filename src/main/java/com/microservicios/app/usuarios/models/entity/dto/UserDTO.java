package com.microservicios.app.usuarios.models.entity.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@NotEmpty
	private String name;

	@NotEmpty
	private String userName;

	@NotEmpty
	@Email
	private String email;

	@NotEmpty
	private String phone;

	public UserDTO(String name, String userName, String email, String phone) {
		this.name = name;
		this.userName = userName;
		this.email = email;
		this.phone = phone;
	}

}