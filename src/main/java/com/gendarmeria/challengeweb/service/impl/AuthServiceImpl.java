package com.gendarmeria.challengeweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gendarmeria.challengeweb.command.AuthCommand;
import com.gendarmeria.challengeweb.dto.LoginDTO;
import com.gendarmeria.challengeweb.dto.ProfileDTO;
import com.gendarmeria.challengeweb.dto.TokenDTO;
import com.gendarmeria.challengeweb.factory.Factory;
import com.gendarmeria.challengeweb.feign.request.LoginFeignRequest;
import com.gendarmeria.challengeweb.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService{

	@Autowired
	private AuthCommand authCommand;

	@Override
	public TokenDTO login(LoginDTO body) {
		
		//Mapeo a DTO del MS de destino (LoginDTO(ms challenge-web) -> LoginDTO(ms auth)
		LoginFeignRequest loginFeignRequest = Factory.getLoginFeignRequest(body);
		
		//Invocando al MS AUTH a través de HystrixCommand
		TokenDTO response = this.authCommand.login(loginFeignRequest);
		
		//retorno al controlador
		return response;
	}

	@Override
	public List<ProfileDTO> getProfiles(String token) {
		// TODO Auto-generated method stub
		return null;
	}

}
