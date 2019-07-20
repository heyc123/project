package com.heyc.gasstation.softem.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.druid.util.Base64;
import com.heyc.gasstation.softem.entity.UserInfo;
import com.heyc.gasstation.softem.msg.TextMessage;
import com.heyc.gasstation.softem.service.UserInfoService;
import com.heyc.gasstation.softem.utils.SignatureUtil;
import com.heyc.gasstation.softem.utils.XmlUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping(value = "/wechatMessage")
@Slf4j
public class WXmessageController {
    private String token = "heyGasStation";
    @Autowired
    private UserInfoService userInfoService;
    /**
     * 用于微信端发送请求验证请求是否来自微信，接入微信开发，Get请求
     * @param signature
     * @param timestamp
     * @param nonce
     * @param echostr
     * @return
     */
    @GetMapping(value = "wechatAuth")
    public String WechatAuth(String signature, String timestamp, String nonce, String echostr) {
        String [] arr = new String[]{token,timestamp,nonce};
        Arrays.sort(arr);
        StringBuffer sub = new StringBuffer();
        Arrays.stream(arr).forEach(str -> sub.append(str));
        log.info("signature={}, timestamp={}, nonce = {}, echostr = {}",signature, timestamp, nonce, echostr);
        String sign = SignatureUtil.sha1Encrypt(sub.toString());
        log.info("sign={}, true={}", sign, signature.equals(sign));
        if (signature.equals(sign)) {
            return echostr;
        }
        return null;
    }

    @PostMapping(value = "wechatAuth")
    public String receivedMsg(HttpServletRequest req) {
        Map<String, String> map = XmlUtil.xmlToMap(req);
        log.info("接收到消息：msgXml={}", map);

        String openId = map.get("FromUserName");
        UserInfo userInfo = userInfoService.getByOpenId(openId);
        if (userInfo == null) {
            userInfo = new UserInfo();
            userInfo.setOpenId(map.get("FromUserName"));
            userInfoService.save(userInfo);
        }
        TextMessage textMessage = new TextMessage();
        textMessage.setMsgType("text");
        textMessage.setMsgId(map.get("MsgId"));
        textMessage.setCreateTime(new Date().getTime()+"");
        String param = Base64.byteArrayToBase64(openId.getBytes());
        textMessage.setContent("欢迎关注heyc，你可以点击 http://heyc.nat300.top/gas/userinfo/userRegister?baseMsg="+ param +" 进行注册信息");
        textMessage.setToUserName(map.get("FromUserName"));
        textMessage.setFromUserName(map.get("ToUserName"));

        log.info(textMessage.toString());
        String respXml = XmlUtil.convertToXml(textMessage);
        log.info("respXml={}", respXml);
        return respXml;
    }

}
