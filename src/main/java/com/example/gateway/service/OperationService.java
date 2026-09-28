package com.example.gateway.service;

import com.example.gateway.dto.OperationRequest;
import com.example.gateway.dto.OperationResponse;

public interface OperationService {
	
	OperationResponse serviceSale(OperationRequest operationRequest);

}
