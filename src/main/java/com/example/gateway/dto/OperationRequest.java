package com.example.gateway.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class OperationRequest {
	
	@NotBlank(message = "Ingrese la operación")
	@Size(min = 5, max = 6, message = "Longitud minima {min} carateres o maxima {max} carateres")
	@Pattern(regexp = "^[A-Za-z]+$", message = "Solo ingrese caracteres validos")
	String operacion;
	
	@NotNull(message = "Ingrese el importe")
	@Digits(integer = 7, fraction = 2, message = "Ingrese un valor valido {integer} digitos y {fraction} decimales")
	BigDecimal importe;
	
	@NotBlank(message = "Ingrese el cliente")
	@Size(min = 3, max = 50, message = "Longitud del cliente debe ser minima {min} carateres o maxima {max} caracteres")
	@Pattern(regexp = "^[\\p{L}\\s'-]+{3,50}$", message = "Solo ingrese caracteres validos")
	String cliente;
	
	@NotBlank(message = "Este dato no puede ser nulo o vacio")
	String secreto;

}
