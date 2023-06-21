package com.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration // 作为配置类，代替xml配置文件
@ComponentScan(basePackages = {"com.spring.autowired"})
public class SpringConfig {
}
