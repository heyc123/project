package com.heyc.gasstation.softem.controller;

import com.alibaba.druid.util.Base64;
import com.heyc.gasstation.softem.entity.UserInfo;
import com.heyc.gasstation.softem.service.UserInfoService;
import com.heyc.gasstation.softem.utils.Response;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/userinfo")
@Slf4j
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;
    
    /**
     * 注册页
     * @param baseMsg
     * @param model
     * @return
     */
    @GetMapping(value = "userRegister")
    public String userRegister(String baseMsg, Model model) {
       String openId = new String(Base64.base64ToByteArray(baseMsg));
        log.info("用户openId={}请求注册页", openId);
        model.addAttribute("openId", openId);
        return "/userinfo/user_register";
    }

    @PostMapping(value = "register")
    @ResponseBody
    public Response register(UserInfo userInfo) {
    	
    	userInfoService.register(userInfo); 
    	
    	return Response.initSuccessResponse(null);
    }
    
}
