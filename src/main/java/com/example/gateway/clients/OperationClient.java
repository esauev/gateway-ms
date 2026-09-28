package com.example.gateway.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.gateway.dto.OperationResponse;

@FeignClient(name="savedata-ms", url = "http://localhost:8081")
public interface OperationClient {
	
	@PostMapping(value = "/operation/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	OperationResponse saveOperation(OperationDto request);

}
