package com.heyc.gasstation.softem.biz;

import com.heyc.gasstation.softem.dao.UserInfoMapper;
import com.heyc.gasstation.softem.entity.UserInfo;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

@Component
public class UserInfoBiz extends BaseBiz<UserInfoMapper, UserInfo, Long> {

    public UserInfo getByOpenId(String openId){
        UserInfo userInfo = new UserInfo();
        userInfo.setOpenId(openId);
        return this.selectOne(userInfo);
    }

    public UserInfo getById(Long id) {
    	Assert.notNull(id,"参数错误");
    	return this.get(id);
    }
    
    /**
     * У�鵱ǰopenId��Ӧ���û��Ƿ��Ѿ���������Ϣ
     * @param openId
     * @return
     */
    public UserInfo checkRegisterStatus(String openId) {
    	Assert.notNull(openId,"参数错误");
    	UserInfo userInfo = this.getByOpenId(openId);
    	if (userInfo != null) {
    		String userName = userInfo.getName();
    		String mobileNumber = userInfo.getMobileNumber();
    		if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(mobileNumber)) {
    			return userInfo;
    		}
    	}
    	return null;
    }
    
}
