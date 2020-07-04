package com.gendarmeria.challengeweb.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gendarmeria.challengeweb.dto.LoginDTO;
import com.gendarmeria.challengeweb.dto.ProfileDTO;
import com.gendarmeria.challengeweb.dto.TokenDTO;
import com.gendarmeria.challengeweb.service.AuthService;
@RestController
@RequestMapping(value = "/auth")
@CrossOrigin("*")
public class AuthController {
	@Autowired
	private AuthService authService;
	
	//http://localhost:10000/auth/login : -> body {userName:<username>, password: <password>}
	@PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TokenDTO> login(@RequestBody LoginDTO body) {
		TokenDTO token = this.authService.login(body);
		return ResponseEntity.ok(token);
	}

	@GetMapping(value = "/profile/{token}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProfileDTO>> getProfiles(@PathParam(value = "token") String token) {
		List<ProfileDTO> profiles = this.authService.getProfiles(token);
		return new ResponseEntity<>(profiles, HttpStatus.OK);
	}
}
