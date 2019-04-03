package com.onemile.bms;

import com.onemile.bms.utils.ToolUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * @author Eric
 */
@SpringBootApplication
@EnableTransactionManagement(order = 2)
@MapperScan("com.onemile.bms.mapper")
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
//
//        String s= HttpRequestUtil.sendGet("http://api.heclouds.com/devices/506066866");
//        System.console().printf(s);


    }



}
