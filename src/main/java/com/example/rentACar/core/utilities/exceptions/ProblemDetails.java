package com.example.rentACar.core.utilities.exceptions;

import com.example.rentACar.business.requests.CreateModelRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProblemDetails {
	
	String message;

}
