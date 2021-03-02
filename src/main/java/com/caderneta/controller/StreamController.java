package com.caderneta.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.caderneta.model.ContaDTO;
import com.caderneta.model.UserDTO;
import com.caderneta.service.IStreamService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/v1")
public class StreamController {
	
	@Autowired
	private IStreamService service;
	
	@ResponseBody
	@PostMapping("/account")
	@ResponseStatus(value = HttpStatus.CREATED)
	@ApiOperation(value = "Create Conta")
	public void createAccount(@Valid @RequestBody ContaDTO dto) {
		service.createAccount(dto);
	}
	
	@ResponseBody
	@PostMapping("/user")
	@ResponseStatus(value = HttpStatus.CREATED)
	@ApiOperation(value = "Create User")
	public void createAccount(@Valid @RequestBody UserDTO dto) {
		service.createUser(dto);
	}
}
