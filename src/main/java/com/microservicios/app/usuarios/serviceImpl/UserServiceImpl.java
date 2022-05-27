package com.microservicios.app.usuarios.serviceImpl;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.microservicios.app.usuarios.clients.UserFeignClient;
import com.microservicios.app.usuarios.exception.UserException;
import com.microservicios.app.usuarios.models.entity.User;
import com.microservicios.app.usuarios.models.entity.dto.ResponseClientDTO;
import com.microservicios.app.usuarios.models.entity.dto.ResponseDTO;
import com.microservicios.app.usuarios.models.entity.dto.ResultClientDTO;
import com.microservicios.app.usuarios.models.entity.dto.UserDTO;
import com.microservicios.app.usuarios.repository.UserRepository;
import com.microservicios.app.usuarios.service.UserService;

import utils.Cifrado;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private UserFeignClient clientUsuario;

	@Override
	public User crearUsuario(UserDTO usuarioDto) {
		User usuario = new User(usuarioDto.getName(), usuarioDto.getUserName(), usuarioDto.getEmail(),
				usuarioDto.getPhone());
		try {
			usuario = repository.save(usuario);
		} catch (Exception e) {
			throw new UserException();
		}
		return usuario;
	}

	@Override
	public User findByEmail(String term) {
		return repository.findByEmail(term);
	}

	@Override
	public List<User> findAll() {
		return (List<User>) repository.findAll();
	}

	@Override
	public ResponseClientDTO getSearch(String rut)
			throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeySpecException,
			NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		String param = Cifrado.encryptForDES(rut, "ionix123456");
		//FyaSTkGi8So=
		int inicio = (int) System.currentTimeMillis();
		ResponseDTO response = clientUsuario.getSearch(param);		
		int fin = (int) System.currentTimeMillis();        
        int elapsedTime = (int) ((fin - inicio));        
        ResultClientDTO result = new ResultClientDTO(response.getResult().getItems().size());
        ResponseClientDTO responseClient = new ResponseClientDTO(0, HttpStatus.OK.getReasonPhrase(), elapsedTime, result);
		return responseClient;
	}
}