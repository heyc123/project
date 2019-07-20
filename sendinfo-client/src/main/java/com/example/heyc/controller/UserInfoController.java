package com.example.heyc.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.example.heyc.dto.SubClass;
import com.example.heyc.dto.UserInfoDto;
import com.example.heyc.service.OrderService;
import com.example.heyc.util.RpcParseUtil;
import com.example.heyc.util.RpcResponse;
import com.google.gson.JsonArray;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/user")
public class UserInfoController {

	@Autowired
	private OrderService orderService;
	
	@GetMapping("getName")
	public void getName(String type, Long sum) {
		RpcResponse<String> result = orderService.getName(type);
		log.info("---------result={}",result.getMessage());
	}
	
	//测试传Map
	@GetMapping("sendMap")
	public void sendMap() {
		Map<String, String> map = new HashMap<>();
		map.put("key", "value");
		map.put("key1", "value1");
		map.put("key2", "value2");
		orderService.sendMap(map);
	}
	
	@GetMapping("sendMapObj")
	public void sendMapObj() {
		Map<String, UserInfoDto> map = new HashMap<>();
		
		UserInfoDto dto = new UserInfoDto();
		dto.setUserName("heyc");
		dto.setTime(new Date());
		dto.setSum(110.2);
		dto.setAge(23);
		dto.setClazz(new SubClass());
		
		List<String> datas = new ArrayList<>();
		datas.add("aaa");
		datas.add("bbbb");

		List<SubClass> subs = new ArrayList<>();
		
		SubClass sub1 = new SubClass();
		sub1.setT1("sub1");
		Map<String, String> subMap = new HashMap<>();
		subMap.put("sub1", "subMap1");
		sub1.setMap(subMap);
		
		SubClass sub2 = new SubClass();
		sub2.setT1("sub2");
		Map<String, String> subMap2 = new HashMap<>();
		subMap2.put("sub2", "subMap2");
		sub2.setMap(subMap2);
		
		subs.add(sub1);
		subs.add(sub2);
		
		dto.setDatas(datas);
		dto.setSubs(subs);
		
		map.put("test", dto);
		
		orderService.sendMapObj(map);
	}
	
	@GetMapping("sendMapList")
	public void sendMapList() {
		Map<String, List<UserInfoDto>> map = new HashMap<>();
		
		 List<UserInfoDto> list1 = new ArrayList<>();
		 UserInfoDto dto = new UserInfoDto();
		 dto.setUserName("heyc");
		 dto.setTime(new Date());
		 dto.setSum(110.2);
		 dto.setAge(23);
		 dto.setClazz(new SubClass());
		 list1.add(dto);
		 
		 
		 List<UserInfoDto> list2 = new ArrayList<>();
		 UserInfoDto dto2 = new UserInfoDto();
		 dto2.setUserName("zt");
		 dto2.setTime(new Date());
		 dto2.setSum(1111.2);
		 dto2.setAge(26);
		 dto2.setClazz(new SubClass());
		 list2.add(dto2);
		 
		 map.put("test", list1);
		 map.put("test", list2);
		
		 orderService.sendMapList(map);
		 
	}
	

	@GetMapping("sendListStr")
	public void sendListStr() {
		 List<String> list = new ArrayList<>();
		 list.add("heyc");
		 list.add("heyc1");
		 list.add("heyc2");
		 orderService.sendListStr(list);
	}
	
	@GetMapping("sendListObj")
	public void sendListObj() {
		 
		 List<UserInfoDto> list2 = new ArrayList<>();
		 UserInfoDto dto1 = new UserInfoDto();
		 dto1.setUserName("zt");
		 dto1.setTime(new Date());
		 dto1.setSum(1111.2);
		 dto1.setAge(26);
		 dto1.setClazz(new SubClass());
		 list2.add(dto1);
		 UserInfoDto dto2 = new UserInfoDto();
		 dto2.setUserName("zt");
		 dto2.setTime(new Date());
		 dto2.setSum(1111.2);
		 dto2.setAge(26);
		 dto2.setClazz(new SubClass());
		 list2.add(dto2);
		 orderService.sendListObj(list2);
	}
	
	@GetMapping("sendListMap")
	public void sendListMap() {
		 
		 List<Map<String, UserInfoDto>> list = new ArrayList<>();
		 UserInfoDto dto = new UserInfoDto();
		 dto.setUserName("zt");
		 dto.setTime(new Date());
		 dto.setSum(1111.2);
		 dto.setAge(26);
		 dto.setClazz(new SubClass());
		 
		 Map<String, UserInfoDto> map = new HashMap<>();
		 map.put("dto", dto);
		 
		 list.add(map);
		 orderService.sendListMap(list);
	}
	
	@GetMapping("sendListObjs")
	public void sendListObjs() {
		List<UserInfoDto> list = new ArrayList<>();
		UserInfoDto dto = new UserInfoDto();
		dto.setUserName("heyc");
		dto.setTime(new Date());
		dto.setSum(110.2);
		dto.setAge(23);
		dto.setClazz(new SubClass());
		
		List<String> datas = new ArrayList<>();
		datas.add("aaa");
		datas.add("bbbb");

		List<SubClass> subs = new ArrayList<>();
		
		SubClass sub1 = new SubClass();
		sub1.setT1("sub1");
		Map<String, String> subMap = new HashMap<>();
		subMap.put("sub1", "subMap1");
		sub1.setMap(subMap);
		
		SubClass sub2 = new SubClass();
		sub2.setT1("sub2");
		Map<String, String> subMap2 = new HashMap<>();
		subMap2.put("sub2", "subMap2");
		sub2.setMap(subMap2);
		
		subs.add(sub1);
		subs.add(sub2);
		
		dto.setDatas(datas);
		dto.setSubs(subs);
		
		list.add(dto);
		
		orderService.sendListObjs(list);
	}
	@GetMapping("sendObj")
	public void sendObj() {
		UserInfoDto dto1 = new UserInfoDto();
		dto1.setUserName("zt");
		dto1.setTime(new Date());
		dto1.setSum(1111.2);
		dto1.setAge(26);
		dto1.setClazz(new SubClass());
		List<UserInfoDto> list = orderService.sendObj(dto1);
		log.info("返回值list={}", JSON.toJSONString(list));
	}
	
	@GetMapping("get")
	public void get() {
	log.info("hahah");
		orderService.get("/server/orderServiceRpc/userInfo");
	}
	
}
