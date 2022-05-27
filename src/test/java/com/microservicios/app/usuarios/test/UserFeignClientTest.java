package com.microservicios.app.usuarios.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.microservicios.app.usuarios.clients.UserFeignClient;
import com.microservicios.app.usuarios.models.entity.dto.ResponseClientDTO;
import com.microservicios.app.usuarios.models.entity.dto.ResponseDTO;
import com.microservicios.app.usuarios.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserFeignClientTest {

	@Autowired
	private UserFeignClient usuarioClient;

	@Autowired
	private UserService userService;

	@BeforeEach
	void initMetodoTest(TestInfo testInfo, TestReporter testReporter) {
		System.out.println("iniciando el metodo.");
		testReporter.publishEntry(" ejecutando: " + testInfo.getDisplayName() + " "
				+ testInfo.getTestMethod().orElse(null).getName() + " con las etiquetas " + testInfo.getTags());

	}

	@Test
	public void shouldLoadSearch() {
		ResponseDTO posts = usuarioClient.getSearch("1-9");
		assertNotNull(posts);
	}

	@Test
	public void shouldLoadServiceSearch()
			throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeySpecException,
			NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		ResponseClientDTO response = userService.getSearch("1-9");
		assertEquals("OK", response.getDescription());
	}
}