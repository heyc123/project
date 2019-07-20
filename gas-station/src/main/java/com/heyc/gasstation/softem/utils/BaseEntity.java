package com.heyc.gasstation.softem.utils;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

public abstract class BaseEntity<PK extends Serializable> extends Entity<PK> {
    @Column(name="CREATE_TIME")
    private Date createTime;
    @Column(name="UPDATE_TIME")
    private Date updateTime;
}
