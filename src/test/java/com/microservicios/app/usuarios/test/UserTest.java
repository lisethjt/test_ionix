package com.microservicios.app.usuarios.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.microservicios.app.usuarios.models.entity.User;
import com.microservicios.app.usuarios.models.entity.dto.UserDTO;
import com.microservicios.app.usuarios.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

	@Autowired
	private UserService usuarioService;

	@BeforeEach
	void initMetodoTest(TestInfo testInfo, TestReporter testReporter) {
		System.out.println("iniciando el metodo.");
		testReporter.publishEntry(" ejecutando: " + testInfo.getDisplayName() + " "
				+ testInfo.getTestMethod().orElse(null).getName() + " con las etiquetas " + testInfo.getTags());

	}

	@AfterEach
	void tearDown() {
		System.out.println("finalizando el metodo de prueba.");
	}

	@BeforeAll
	static void beforeAll() {
		System.out.println("inicializando el test");
	}

	@AfterAll
	static void afterAll() {
		System.out.println("finalizando el test");
	}

	@Test
	void saveUserTest() {
		UserDTO usuarioDto = new UserDTO("Jeronimo", "jeronimo3.cacua", "jero3@gmail.com", "6874563");
		User usuario = usuarioService.crearUsuario(usuarioDto);
		assertEquals("Jeronimo", usuario.getName());
		assertEquals("jero3@gmail.com", usuario.getEmail());
	}

	@Test
	void listUsersTest() {
		List<User> usuarios = usuarioService.findAll();
		assertFalse(usuarios.isEmpty());
	}

	@Test
	void getUserTest() {
		User usuario = usuarioService.findByEmail("jero@gmail.com");
		assertEquals("Jeronimo", usuario.getName());
	}
}