package com.example.heyc.service;

import java.util.List;
import java.util.Map;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.heyc.dto.UserInfoDto;
import com.example.heyc.util.RpcResponse;

@FeignClient(name = "server", url="127.0.0.1:8081", fallback=OrderServiceFallBack.class)
public interface OrderService extends BaseService{
 
	@RequestMapping(value = "/server/orderServiceRpc/userInfo/getName", method = RequestMethod.GET)
	public RpcResponse<String> getName(@RequestParam("type") String type);
	
	@RequestMapping(value = "/server/orderServiceRpc/userInfo/sendMap", method = RequestMethod.GET)
	public RpcResponse<String>sendMap(@RequestBody Map<String, String> map) ;	
	
	@RequestMapping(value = "/server/orderServiceRpc/userInfo/sendMapObj", method = RequestMethod.GET)
	public RpcResponse<String> sendMapObj(@RequestBody Map<String, UserInfoDto> map) ;	
	
	@RequestMapping(value = "/server/orderServiceRpc/userInfo/sendMapList", method = RequestMethod.GET)
	public RpcResponse<String> sendMapList(@RequestBody Map<String, List<UserInfoDto>> map) ;	
	
	@RequestMapping(value = "/server/orderServiceRpc/userInfo/sendListStr", method = RequestMethod.GET)
	public RpcResponse<String> sendListStr(@RequestBody List<String> list) ;
	
	@RequestMapping(value = "/server/orderServiceRpc/userInfo/sendListObj", method = RequestMethod.GET)
	public RpcResponse<String> sendListObj(@RequestBody List<UserInfoDto> list) ;	
	
	@RequestMapping(value = "/server/orderServiceRpc/userInfo/sendListMap", method = RequestMethod.GET)
	public RpcResponse<String> sendListMap(@RequestBody List<Map<String, UserInfoDto>> map) ;	
	
	@RequestMapping(value = "/server/orderServiceRpc/userInfo/sendListObjs", method = RequestMethod.GET)
	public List<UserInfoDto> sendListObjs(@RequestBody List<UserInfoDto> list) ;	
	
	@RequestMapping(value = "/server/orderServiceRpc/userInfo/sendObj", method = RequestMethod.GET)
	public List<UserInfoDto> sendObj(@RequestBody UserInfoDto dto) ;	
	
	public static String getUrl() {
		return "/server/orderServiceRpc/userInfo";
	}
	
}
