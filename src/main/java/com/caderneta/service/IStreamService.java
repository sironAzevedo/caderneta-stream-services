package com.caderneta.service;

import com.caderneta.model.ContaDTO;
import com.caderneta.model.UserDTO;

public interface IStreamService {
	
	void createUser(UserDTO user);

	void createAccount(ContaDTO conta);
}
