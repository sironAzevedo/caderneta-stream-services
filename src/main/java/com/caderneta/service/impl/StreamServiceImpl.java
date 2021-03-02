package com.caderneta.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caderneta.client.UserClient;
import com.caderneta.handler.exception.UserException;
import com.caderneta.kafka.producer.StreamProducer;
import com.caderneta.model.ContaDTO;
import com.caderneta.model.UserDTO;
import com.caderneta.service.IStreamService;

@Service
public class StreamServiceImpl implements IStreamService {
	
	@Autowired
	private UserClient userClient;
	
	@Autowired
	private StreamProducer producer;

	@Override
	public void createUser(UserDTO user) {
		if (userClient.findByEmail(user.getEmail()) != null) {
			throw new UserException("User exist");
		}
		producer.sendUser(user);
	}

	@Override
	public void createAccount(ContaDTO conta) {
		if (userClient.findByEmail(conta.getEmailUser()) == null) {
			throw new UserException("User not found");
		}		
		producer.sendAccount(conta);
	}
}
