package com.gendarmeria.challengeweb.factory;

import com.gendarmeria.challengeweb.dto.LoginDTO;
import com.gendarmeria.challengeweb.dto.TokenDTO;
import com.gendarmeria.challengeweb.feign.request.LoginFeignRequest;
import com.gendarmeria.challengeweb.feign.response.TokenFeignResponse;

public class Factory {

	public static LoginFeignRequest getLoginFeignRequest(LoginDTO login) {
		if (login == null) {
			return null;
		}
		LoginFeignRequest response = new LoginFeignRequest();
		response.setPassword(login.getPassword());
		response.setUserName(login.getUserName());
		return response;
	}

	public static TokenDTO getTokenDTO(TokenFeignResponse token) {
		if (token == null) {
			return null;
		}
		TokenDTO response = new TokenDTO();
		response.setToken(token.getToken());
		return response;
	}

}
