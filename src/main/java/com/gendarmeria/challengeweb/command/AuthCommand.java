package com.gendarmeria.challengeweb.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.gendarmeria.challengeweb.dto.TokenDTO;
import com.gendarmeria.challengeweb.exception.ChallengeWebException;
import com.gendarmeria.challengeweb.factory.Factory;
import com.gendarmeria.challengeweb.feign.client.AuthFeignClient;
import com.gendarmeria.challengeweb.feign.request.LoginFeignRequest;
import com.gendarmeria.challengeweb.feign.response.TokenFeignResponse;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class AuthCommand {

	@Autowired
	private AuthFeignClient authFeignClient;

	@HystrixCommand(fallbackMethod = "loginError")
	public TokenDTO login(LoginFeignRequest loginFeignRequest) throws ChallengeWebException {

		// Invocando al end point auth/login -> (ms auth)
		ResponseEntity<TokenFeignResponse> responseEntity = this.authFeignClient.login(loginFeignRequest);

		// Obteniendo el json de respuesta (DTO) del endpoint auth/login -> (ms auth)
		TokenFeignResponse tokenFeingResponse = responseEntity.getBody();

		// Retorno del mapeo de respuesta al service.
		return Factory.getTokenDTO(tokenFeingResponse);
	}

	public TokenDTO loginError(LoginFeignRequest loginFeignRequest) throws ChallengeWebException {
		throw new ChallengeWebException("Error en la comunicación con Auth MS", HttpStatus.NOT_FOUND);
	}
}
