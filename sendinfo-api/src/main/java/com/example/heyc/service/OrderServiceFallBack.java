package com.example.heyc.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.heyc.dto.UserInfoDto;
import com.example.heyc.util.RpcResponse;

import lombok.extern.slf4j.Slf4j;
@Component
@Slf4j
public class OrderServiceFallBack implements OrderService {

	@Override
	public RpcResponse<String> getName(String type) {
		log.info("+++++++++++++++++++_+__+++++_####+++++++++++++,thread={}",Thread.currentThread().getName());
		return RpcResponse.isError("远程调用超时导致失败+++++++++", String.class);
	}


	@Override
	public void get(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RpcResponse<String> sendMap(Map<String, String> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RpcResponse<String> sendMapObj(Map<String, UserInfoDto> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RpcResponse<String> sendMapList(Map<String, List<UserInfoDto>> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RpcResponse<String> sendListStr(List<String> list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RpcResponse<String> sendListObj(List<UserInfoDto> list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RpcResponse<String> sendListMap(List<Map<String, UserInfoDto>> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserInfoDto> sendListObjs(List<UserInfoDto> list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserInfoDto> sendObj(UserInfoDto dto) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
