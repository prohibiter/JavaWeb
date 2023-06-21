package com.SpringMVC.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 代替SpringMVC配置文件
 * 1、扫描组件 2、视图解析器 3、view-controller 4、default-servlet-handler
 * 5、mvc注解驱动 6、文件上传解析器 7、异常处理 8、拦截器
 */
@Configuration
@ComponentScan
@EnableWebMvc //开启MVC注解驱动
public class WebConfig {

}
