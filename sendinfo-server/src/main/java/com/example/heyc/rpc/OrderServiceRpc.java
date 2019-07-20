package com.example.heyc.rpc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.heyc.dto.SubClass;
import com.example.heyc.dto.UserInfoDto;
import com.example.heyc.exception.RpcException;
import com.example.heyc.util.RpcResponse;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
public class OrderServiceRpc {
	
	@GetMapping(value = "/orderServiceRpc/userInfo/getName")
	@HystrixCommand(fallbackMethod="getNameFallBck")
	public RpcResponse<String> getName(String type) throws InterruptedException {
		
		List<String> datas = new ArrayList<>();
		log.info("------rpc请求参数type={},thread={}", type,Thread.currentThread().getName());
				if (type.equals("1")) {
					Thread.sleep(4000);
					log.info("线程醒来");
					//int i = 1/0;
					datas.add("success heyc");
				} else if (type.equals("2")) {
					datas.add("success heyc");
				}
		return RpcResponse.isSuccess(datas, String.class);
	}
	
	public RpcResponse<String> getNameFallBck(String type, Throwable e) {
		log.info("访问出错了,进入断路器,异常信息e=", e);
		return RpcResponse.isError("访问出错了", String.class);
	}
	
	@HystrixCommand(defaultFallback="defaultFallback")
	@RequestMapping(value="/orderServiceRpc/userInfo/sendMap", method = {RequestMethod.GET,RequestMethod.POST})
	public void sendMap(@RequestBody Map<String, UserInfoDto> map) {
		
		log.info("测试参数为map集合,map={}", map);
	}
	
	@HystrixCommand(fallbackMethod="sendMapObjFallback")
	@RequestMapping(value="/orderServiceRpc/userInfo/sendMapObj", method = {RequestMethod.GET,RequestMethod.POST})
	public void sendMapObj(@RequestBody Map<String, UserInfoDto> map) {
		
		log.info("测试参数为sendMapObj集合,sendMapObj={}", map);
		
		int i = 1/0;
		
	}
	
	@HystrixCommand(defaultFallback="defaultFallback")
	@RequestMapping(value="/orderServiceRpc/userInfo/sendMapList", method = {RequestMethod.GET,RequestMethod.POST})
	public void sendMapList(@RequestBody Map<String, List<UserInfoDto>> map) {
		log.info("测试参数为sendMapList集合,sendMapObj={}", map);
		Assert.isTrue(1>2, "算数异常");
	}
	
	@HystrixCommand(defaultFallback="defaultFallback")
	@RequestMapping(value="/orderServiceRpc/userInfo/sendListStr", method = {RequestMethod.GET,RequestMethod.POST})
	public void sendListStr(@RequestBody List<String> list) {
		
		log.info("测试参数为sendListStr集合,sendListStr={}", list);
		list.get(20);
	}
	
	@HystrixCommand(defaultFallback="defaultFallback")
	@RequestMapping(value="/orderServiceRpc/userInfo/sendListObj", method = {RequestMethod.GET,RequestMethod.POST})
	public void sendListObj(@RequestBody List<UserInfoDto> list){
		
		log.info("测试参数为sendListObj集合,sendListObj={}", list);
		list.get(0).getClazz().getT1();
	}
	
	@HystrixCommand(defaultFallback="defaultFallback")
	@RequestMapping(value="/orderServiceRpc/userInfo/sendListMap", method = {RequestMethod.GET,RequestMethod.POST})
	public void sendListMap(@RequestBody List<Map<String, UserInfoDto>> map) {
		
		log.info("测试参数为sendListMap集合,sendListMap={}", map);
	}
	
	@HystrixCommand(defaultFallback="defaultFallback")
	@RequestMapping(value="/orderServiceRpc/userInfo/sendListObjs", method = {RequestMethod.GET,RequestMethod.POST})
	public void sendListObjs(@RequestBody List<UserInfoDto> list) {
		
		log.info("测试参数为sendListObjs集合,sendListObjs={}", list);
	}
	
	@HystrixCommand(fallbackMethod="sendMapObjFallback")
	@RequestMapping(value="/orderServiceRpc/userInfo/sendObj", method = {RequestMethod.GET,RequestMethod.POST})
	public RpcResponse<UserInfoDto> sendObj(@RequestBody UserInfoDto dto) {
		
		try {
			log.info("测试参数为sendObj集合,sendObj={}", dto);
			int i = 1/0;
			UserInfoDto dto1 = new UserInfoDto();
			dto1.setUserName("zt");
			dto1.setTime(new Date());
			dto1.setSum(1111.2);
			dto1.setAge(26);
			dto1.setClazz(new SubClass());
			List<UserInfoDto> list = new ArrayList<>();
			list.add(dto1);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return RpcResponse.isError(e.getMessage(), UserInfoDto.class);
		}
		
	}
	
	public void defaultFallback(Throwable e) {
		log.info("来到断路器e=",e);
	}
	public RpcResponse<String> sendMapObjFallback(Map<String, UserInfoDto> map, Throwable e) {
		log.info("测试参数为sendMapList集合23234,sendMapObj={}", map);
		log.info("来到断路器234e=",e);
		return null;
	}
	
	public static void main(String[] args) {
		
		Optional<String> str = Optional.ofNullable(null);
		log.info(str.orElse("haha"));
		
		UserInfoDto dto = new UserInfoDto();
		dto.setUserName("heyc");
		
		SubClass sub = new SubClass();
		sub.setT1("fcl");
		dto.setClazz(sub);
		
		Optional<UserInfoDto> optional = Optional.ofNullable(null);
		Optional<String> t = optional.map(d-> d.getClazz()).map(s->s.getT1());
	}
	
	
}
