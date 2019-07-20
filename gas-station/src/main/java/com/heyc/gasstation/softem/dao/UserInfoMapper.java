package com.heyc.gasstation.softem.dao;

import com.heyc.gasstation.softem.entity.UserInfo;
import com.heyc.gasstation.softem.utils.BaseMapper;

public interface UserInfoMapper extends BaseMapper<UserInfo> {

    public UserInfo getByOpenId(String openId);

}
