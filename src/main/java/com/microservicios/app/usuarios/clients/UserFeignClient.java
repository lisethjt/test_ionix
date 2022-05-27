package com.microservicios.app.usuarios.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.microservicios.app.usuarios.models.entity.dto.ResponseDTO;

@FeignClient(name = "search", url = "https://stoplight.io/mocks/spbusiness/test-tecnico/11631269/test-tecnico/search")
public interface UserFeignClient {

	@GetMapping
	public ResponseDTO getSearch(@RequestParam String rut);
}