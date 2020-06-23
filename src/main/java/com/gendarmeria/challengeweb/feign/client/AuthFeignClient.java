package com.gendarmeria.challengeweb.feign.client;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.gendarmeria.challengeweb.feign.request.LoginFeignRequest;
import com.gendarmeria.challengeweb.feign.response.ProfileFeignResponse;
import com.gendarmeria.challengeweb.feign.response.TokenFeignResponse;

@FeignClient(name = "auth")
public interface AuthFeignClient {

	@PostMapping(value = "/auth/login", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TokenFeignResponse> login(@RequestBody LoginFeignRequest body);

	@GetMapping(value = "/auth/profile/{token}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProfileFeignResponse>> getProfiles(@PathParam(value = "token") String token);
}
