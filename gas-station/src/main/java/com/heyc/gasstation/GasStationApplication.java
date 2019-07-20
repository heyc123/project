package com.heyc.gasstation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@ComponentScan("com.heyc.gasstation.softem")
@MapperScan("com.heyc.gasstation.softem.dao")
public class GasStationApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(GasStationApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(GasStationApplication.class);
    }
}
