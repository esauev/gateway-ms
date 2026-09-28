package com.example.gateway.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.gateway.clients.OperationClient;
import com.example.gateway.clients.OperationDto;
import com.example.gateway.dto.OperationRequest;
import com.example.gateway.dto.OperationResponse;
import com.example.gateway.utils.AesUtil;

@Service
public class OperationServiceImpl implements OperationService {
	
	@Value( "${encrypt.key}" )
	private String SECRET_KEY;// = "nP46Ny7YzjAxG9Ci/q2Y5g==";
	
	private Logger log = LoggerFactory.getLogger(OperationServiceImpl.class);
	
	@Autowired
	private AesUtil aesUtil;
	
	@Autowired
	private OperationClient operationClient;

	@Override
	public OperationResponse serviceSale(OperationRequest operationRequest) {
		log.info("request: {}", operationRequest);
		
		OperationResponse response = null;
		OperationDto dto = new OperationDto(
				operationRequest.getOperacion(),
				operationRequest.getImporte(),
				operationRequest.getCliente(), null);
		
		try {
//			String encrypt = aesUtil.encrypt(operationRequest.getSecreto(), SECRET_KEY);
//			log.info("encrypt: {}", encrypt);
			
			String decrypt = aesUtil.decrypt(operationRequest.getSecreto(), SECRET_KEY);
			log.info("decrypt: {}", decrypt);
			dto.setSecreto(decrypt);
		} catch (Exception e) {
			log.error("error encrypt: {}", e);
		}
		
		try {
			response = operationClient.saveOperation(dto);
		} catch (Exception e) {
			log.error("Error client: {}", e);
		}
		
		return response;
	}

}
