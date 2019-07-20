package com.heyc.gasstation.softem.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.heyc.gasstation.softem.utils.BusinessException;
import com.heyc.gasstation.softem.utils.Response;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BusinessException.class)	
	public Response handlerMyException(BusinessException ex) {
		ex.printStackTrace();
		String message = ex.getMessage();
		return Response.initFailResponse(message);
	}
	
	@ExceptionHandler(Exception.class)	
	public Response handlerException(Exception ex) {
		ex.printStackTrace();
		String message = ex.getMessage();
		return Response.initFailResponse(message);
	}
	
}
