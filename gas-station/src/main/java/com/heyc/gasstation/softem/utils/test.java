package com.heyc.gasstation.softem.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.util.Assert;

import com.heyc.gasstation.softem.entity.UserInfo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class test {
	
	public void get() {
		
		List<UserInfo> datas = new ArrayList<>();
		UserInfo userInfo = new UserInfo();
		userInfo.setName("heyc");
		userInfo.setMobileNumber("123");
		userInfo.setId(123456L);
		datas.add(userInfo);
		
		tt1(tt2("何裕超"));
		
		
	}
	
	public <T> T tt1(RpcResponse<T> rpc) {
		Integer status = rpc.getStatus();
		Assert.isTrue(status == 200, rpc.getMessage());
		List<T> list = rpc.getDatas();
		T t = list.get(0);
		return t;
	}
	
	public RpcResponse<HashMap> tt2(String str) {
		List<HashMap> datas = new ArrayList<>();
		HashMap<String, String> map = new HashMap<>();
		map.put("hyc", "heyc");
		datas.add(map);
		//RpcResponse<UserInfo> rpc = RpcResponse.isError("远程接口请求异常", UserInfo.class);
		RpcResponse<HashMap> rpc = RpcResponse.isSuccess(datas, HashMap.class);
		return rpc;
	};
	
	
	public static void main(String[] args) {
		test t = new test();
		t.get();
	}
	
	
	
	
}
