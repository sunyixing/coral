package com.coral.business;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@MapperScan("com.coral.business.mapper")
@ComponentScan(basePackages = {"com.coral.business.*"})
@Controller
public class RegisterApplication {
    public static void main(String[] args) {
        SpringApplication.run(RegisterApplication.class,args);
    }
}
