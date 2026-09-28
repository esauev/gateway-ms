package com.example.gateway.service;

import com.example.gateway.dto.EncryptRequest;
import com.example.gateway.dto.EncryptResponse;

public interface EncryptService {
	
	public EncryptResponse encrypt(EncryptRequest request);

}
