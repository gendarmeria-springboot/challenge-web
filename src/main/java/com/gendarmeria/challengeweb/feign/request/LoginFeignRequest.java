package com.gendarmeria.challengeweb.feign.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginFeignRequest {
	private String userName;
	private String password;
}
