package com.example.gateway.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class OperationResponse {
	
	String id;
	String estatus;
	String referencia;
	String operacion;

}
