package com.gendarmeria.challengeweb.feign.client;

import javax.websocket.server.PathParam;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.gendarmeria.challengeweb.feign.request.LoginFeignRequest;
import com.gendarmeria.challengeweb.feign.response.TokenFeignResponse;
import com.gendarmeria.challengeweb.feign.response.UserFeingResponse;

@FeignClient(name = "auth")
public interface AuthFeignClient {

	// Llamando al endpoint login del controlador auth del ms auth.
	@PostMapping(value = "/auth/login", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TokenFeignResponse> login(@RequestBody LoginFeignRequest body);

	// Llamando al endpoint get del controlador user del ms auth.
	@GetMapping(value = "/user/{token}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserFeingResponse> read(@PathParam(value = "token") String token);
}
