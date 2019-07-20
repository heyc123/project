package com.heyc.gasstation.softem.entity;

import com.heyc.gasstation.softem.utils.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "USER_INFO")
public class UserInfo extends BaseEntity<Long> {
    @Column(name="NAME")
    private String name;
    
    @Column(name="PASSWORD")
    private String password;
    /**
     * 寰俊鍒悕
     */
    @Column(name="WECHAT_NAME")
    private String wechatName;
    /**
     * 鎺ㄨ崘浜烘墜鏈哄彿
     */
    @Column(name="RECOMMEND_TEL")
    private String recommendTel;
    /**
     * 鎵嬫満鍙�
     */
    @Column(name="MOBILE_NUMBER")
    private String mobileNumber;

    @Column(name="OPEN_ID")
    private String openId;
}
