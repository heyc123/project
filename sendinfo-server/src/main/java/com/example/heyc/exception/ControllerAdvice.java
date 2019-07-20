package com.example.heyc.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.heyc.util.RpcResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class ControllerAdvice {

	@ExceptionHandler(RpcException.class)	
	public RpcResponse<String> handlerMyException(RpcException ex) {
		ex.printStackTrace();
		String message = ex.getMessage();
		StackTraceElement stackTraceElement= ex.getStackTrace()[0];
		log.info(stackTraceElement.getClassName() + "-->" + stackTraceElement.getMethodName() + "出现" + message +",行号:" + stackTraceElement.getLineNumber());
		return RpcResponse.isError(message, String.class);
	}
	
	
}
