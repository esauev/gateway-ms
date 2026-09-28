package com.example.gateway.clients;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class OperationDto {
	
	String operacion;
	
	BigDecimal importe;
	
	String cliente;
	
	String secreto;

}
