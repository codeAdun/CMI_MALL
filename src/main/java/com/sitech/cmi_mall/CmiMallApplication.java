package com.sitech.cmi_mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.sitech.cmi_mall.dao")
public class CmiMallApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmiMallApplication.class, args);

        System.out.println("2222");
    }

}
