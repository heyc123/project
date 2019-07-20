package com.example.heyc.exception;

public class RpcException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	private String status;
	private String message;
	
	public RpcException(String message) {
		System.out.println("补货异常");
		this.message = message;
	}
	public RpcException(String status, String message) {
		this.status = status;
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
