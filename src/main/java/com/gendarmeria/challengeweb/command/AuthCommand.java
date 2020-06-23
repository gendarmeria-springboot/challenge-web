package com.gendarmeria.challengeweb.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.gendarmeria.challengeweb.dto.TokenDTO;
import com.gendarmeria.challengeweb.factory.Factory;
import com.gendarmeria.challengeweb.feign.client.AuthFeignClient;
import com.gendarmeria.challengeweb.feign.request.LoginFeignRequest;
import com.gendarmeria.challengeweb.feign.response.TokenFeignResponse;

@Component
public class AuthCommand {

	@Autowired
	private AuthFeignClient authFeignClient;

	public TokenDTO login(LoginFeignRequest loginFeignRequest) {
		ResponseEntity<TokenFeignResponse> responseEntity = this.authFeignClient.login(loginFeignRequest);
		TokenDTO response = Factory.getTokenDTO(responseEntity.getBody());
		return response ;
	}

}
