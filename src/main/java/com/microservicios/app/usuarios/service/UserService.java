package com.microservicios.app.usuarios.service;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.microservicios.app.usuarios.models.entity.User;
import com.microservicios.app.usuarios.models.entity.dto.ResponseClientDTO;
import com.microservicios.app.usuarios.models.entity.dto.UserDTO;

public interface UserService {

	public User crearUsuario(UserDTO usuario);

	public User findByEmail(String term);

	public List<User> findAll();

	public ResponseClientDTO getSearch(String rut)
			throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeySpecException,
			NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException;
}