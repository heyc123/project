package com.heyc.gasstation.softem.service;

import com.heyc.gasstation.softem.entity.UserInfo;
import org.springframework.stereotype.Service;

public interface UserInfoService {

    public UserInfo getByOpenId(String openId);
    public UserInfo get(Long id);
    public UserInfo save(UserInfo userInfo);
    public void register(UserInfo userInfo);
}
