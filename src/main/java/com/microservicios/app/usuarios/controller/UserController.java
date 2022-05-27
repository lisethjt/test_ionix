package com.microservicios.app.usuarios.controller;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservicios.app.usuarios.models.entity.User;
import com.microservicios.app.usuarios.models.entity.dto.Response;
import com.microservicios.app.usuarios.models.entity.dto.ResponseClientDTO;
import com.microservicios.app.usuarios.models.entity.dto.UserDTO;
import com.microservicios.app.usuarios.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService service;

	@PostMapping
	public ResponseEntity<?> crearUsuario(@Valid @RequestBody UserDTO usuarioDTO, BindingResult result) {
		if (result.hasErrors()) {
			return validar(result);
		}

		User usuario = service.crearUsuario(usuarioDTO);
		return ResponseEntity.status(HttpStatus.OK).body(usuario);
	}

	@GetMapping("/usuarios")
	public ResponseEntity<?> listarUsuarios() {
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}

	@GetMapping("/{email}")
	public ResponseEntity<?> buscarUsuario(@PathVariable String email) {
		User usuario = service.findByEmail(email);
		if (usuario == null) {
			Response response = new Response("No se encontrarom coincidencias");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}

		return ResponseEntity.status(HttpStatus.OK).body(usuario);
	}

	protected ResponseEntity<?> validar(BindingResult result) {
		Map<String, Object> errores = new HashMap<>();
		result.getFieldErrors().forEach(err -> {
			errores.put(err.getField(), " El campo " + err.getField() + " " + err.getDefaultMessage());
		});
		return ResponseEntity.badRequest().body(errores);
	}

	@PostMapping("/getSearch/{rut}")
	public ResponseEntity<?> getSearch(@PathVariable String rut)
			throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeySpecException,
			NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		ResponseClientDTO responseDTO = service.getSearch(rut);
		return ResponseEntity.ok(responseDTO);
	}
}