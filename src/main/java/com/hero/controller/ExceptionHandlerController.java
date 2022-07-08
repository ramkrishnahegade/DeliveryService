package com.hero.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;

import com.hero.exception.BusinessValidationException;
import com.hero.vo.ErrorResponseModel;

@RestControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler(value= {BusinessValidationException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponseModel handleBusinessException(BusinessValidationException businessException){
		ErrorResponseModel errorResponseModel =new ErrorResponseModel();
		errorResponseModel.setErrorcode(businessException.getErrorCode());
		errorResponseModel.setErrormessage(businessException.getErrormessage());
		return errorResponseModel;
		
	}
	
	
}
