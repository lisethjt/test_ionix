package com.microservicios.app.usuarios.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.microservicios.app.usuarios.models.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

	@Query("SELECT u FROM User u WHERE u.email=?1")
	public User findByEmail(String term);
}