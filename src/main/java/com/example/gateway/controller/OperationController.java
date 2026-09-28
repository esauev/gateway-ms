package com.example.gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gateway.dto.EncryptRequest;
import com.example.gateway.dto.EncryptResponse;
import com.example.gateway.dto.OperationRequest;
import com.example.gateway.dto.OperationResponse;
import com.example.gateway.service.EncryptService;
import com.example.gateway.service.OperationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/operacion")
@CrossOrigin(origins = "http://localhost:4200")
public class OperationController {
	
	@Autowired
	private OperationService operationService;
	
	@Autowired
	private EncryptService encryptService;
	
	@PostMapping(value = "/venta", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public OperationResponse sale(@Valid @RequestBody OperationRequest operationRequest) {
		return operationService.serviceSale(operationRequest);
	}
	
	@PostMapping(value = "/encrypt-secreto", consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public EncryptResponse encryptSecret(@RequestBody EncryptRequest request) { 
		return encryptService.encrypt(request);
	}

}
