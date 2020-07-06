package com.gendarmeria.challengeweb.service;

import java.util.List;

import com.gendarmeria.challengeweb.dto.LoginDTO;
import com.gendarmeria.challengeweb.dto.ProfileDTO;
import com.gendarmeria.challengeweb.dto.TokenDTO;
import com.gendarmeria.challengeweb.exception.ChallengeWebException;

public interface AuthService {

	TokenDTO login(LoginDTO body) throws ChallengeWebException;

	List<ProfileDTO> getProfiles(String token);

}
