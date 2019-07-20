package com.example.heyc.util;

import java.io.Serializable;
import java.util.List;

/**
 * 远程rpc接口返回值封装,包含异常信息和正确的返回值
 * @author heyc
 * @param <T>: 预期返回值类型
 */
public class RpcResponse<T> implements Serializable {

	private Integer status;
	
	private String message;
	
	private List<T> datas;
	
	private static final Integer SUCCESS_STATUS = 200;
	private static final Integer ERROR_STATUS = 500;
	
	private RpcResponse() {
	}
	
	private RpcResponse(Integer status) {
		this.status = status;
	}
	
	private RpcResponse(Integer status, String message, Class<T> clazz) {
		this.status = status;
		this.message = message;
	} 
	private RpcResponse(Integer status, List<T> datas, Class<T> clazz) {
		this.status = status;
		this.datas = datas;
	} 
	
	public static<T> RpcResponse<T> isSuccess(List<T> datas, Class<T> clazz) {
		RpcResponse<T> rpc = new RpcResponse<T>(SUCCESS_STATUS, datas, clazz);
		return rpc;
	}
	
	public static<T> RpcResponse<T> isError(String message, Class<T> clazz) {
		RpcResponse<T> rpc = new RpcResponse<T>(ERROR_STATUS, message, clazz);
		return rpc;
	}
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}

}
