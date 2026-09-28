package com.example.gateway.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.gateway.dto.EncryptRequest;
import com.example.gateway.dto.EncryptResponse;
import com.example.gateway.utils.AesUtil;

@Service
public class EncryptServiceImpl implements EncryptService {
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	@Value( "${encrypt.key}" )
	private String SECRET_KEY;
	
	@Autowired
	private AesUtil aesUtil;

	@Override
	public EncryptResponse encrypt(EncryptRequest request) {
		log.info("palabra: {}", request);
		String secreto = null;
		try {
			secreto = aesUtil.encrypt(request.getPalabra(), SECRET_KEY);
			log.info("secreto: {}", secreto);
		} catch (Exception e) {
			log.error("error: {}", e);
		}
		return new EncryptResponse(secreto);
	}

}
