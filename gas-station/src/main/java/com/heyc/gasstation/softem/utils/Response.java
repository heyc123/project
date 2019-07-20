package com.heyc.gasstation.softem.utils;

import java.util.List;

import org.springframework.util.StringUtils;

import com.heyc.gasstation.softem.ResponseEnum;

import lombok.Data;

/**
 * «Î«ÛœÏ”¶¿‡
 * @author heyc
 *
 */
@Data
public class Response {

	private String status;
	private String message;
	private List<DataGrid> data;
	
	public Response() {}
	
	public Response(String status, String message) {
		this.status = status;
		this.message = message;
	}
	
	public Response setData(List<DataGrid> data) {
		this.data = data;
		return this;
	}
	
	public static Response initSuccessResponse(List<DataGrid> data) {
		Response res = new Response(ResponseEnum.RESPONSE_STATUS_SUCCESS.getKey(),
				ResponseEnum.RESPONSE_STATUS_SUCCESS.getValue());
		if (data != null) {
			res.setData(data);
		}
		return res;
	}
	
	public static Response initFailResponse(String message) {
		Response res = new Response(ResponseEnum.RESPONSE_STATUS_FAIL.getKey(),
				ResponseEnum.RESPONSE_STATUS_FAIL.getValue());
		if (!StringUtils.isEmpty(message)) {
			res.setMessage(message);
		}
		return res;
	}
}
