package com.example.heyc.util;

import java.util.List;

import org.springframework.util.Assert;

import lombok.extern.slf4j.Slf4j;

public class RpcParseUtil {
	
	public static<T> T parseResult(RpcResponse<T> rpc) {
		Integer status = rpc.getStatus();
		Assert.isTrue(status == 200, rpc.getMessage());
		List<T> list = rpc.getDatas();
		T t = list.get(0);
		return t;
	}
}
