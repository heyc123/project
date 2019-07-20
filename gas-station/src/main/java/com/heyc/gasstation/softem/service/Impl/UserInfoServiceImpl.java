package com.heyc.gasstation.softem.service.Impl;

import com.alibaba.druid.support.json.JSONUtils;
import com.heyc.gasstation.softem.biz.UserInfoBiz;
import com.heyc.gasstation.softem.dao.UserInfoMapper;
import com.heyc.gasstation.softem.entity.UserInfo;
import com.heyc.gasstation.softem.service.UserInfoService;
import com.heyc.gasstation.softem.utils.JSON;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoBiz userInfoBiz;

    @Override
    public UserInfo getByOpenId(String openId) {
        log.info("查询人员信息：openId={}", openId);
        UserInfo userInfo = userInfoBiz.getByOpenId(openId);
        log.info(userInfo.toString());
        return userInfo;
    }

    @Override
    public UserInfo get(Long id) {
        UserInfo userInfo = userInfoBiz.get(id);
        log.info(userInfo.toString());
        return null;
    }

    @Override
    public UserInfo save(UserInfo userInfo) {
        return userInfoBiz.save(userInfo);
    }

	@Override
	public void register(UserInfo userInfoDto) {
		log.info("用户注册信息userInfo={}", JSON.JSONTOString(userInfoDto));
		Assert.notNull(userInfoDto, "参数错误");
		Assert.notNull(userInfoDto.getName(), "请输入名称");
		Assert.notNull(userInfoDto.getMobileNumber(), "请输入手机号");
		UserInfo userInfo = userInfoBiz.checkRegisterStatus(userInfoDto.getOpenId());
		Assert.isTrue(userInfo != null, "您已经注册过,不能重复注册!");
		userInfo.setName(userInfoDto.getName());
		userInfo.setMobileNumber(userInfoDto.getMobileNumber());
		userInfo.setPassword(userInfoDto.getPassword());
		userInfoBiz.update(userInfo);
	}
}
