package com.heyc.gasstation.softem.utils;

import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
@Component
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
