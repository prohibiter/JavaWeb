package com.example.springcloud.service;

import ch.qos.logback.core.util.TimeUtil;
import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    /**
     * 正常访问
     *
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id) {
        return "线程池： " + Thread.currentThread().getName() + "   paymentInfo_OK :  " + id + "\t" + "hhhh";
    }

    /**
     * 错误访问
     * 错误处理函数、需求属性
     * 会使用单独的线程池，保证线程隔离
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfo_Timeout(Integer id) {
        int timeNumber = 1000;
        try {
            TimeUnit.MILLISECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池： " + Thread.currentThread().getName() + "   paymentInfo_Timeout :  " + id + "\t" + "hhhh  耗时" + timeNumber + "秒钟";
    }

    public String paymentInfo_TimeoutHandler(Integer id) {
        return "线程池： " + Thread.currentThread().getName() + "   paymentInfo_TimeoutHandler :  " + id + "\t" + "55555555555";
    }

    // 服务熔断

    /**
     * 服务熔断将会使所有的请求直接跳过正确的处理流程，直接进入fallback
     * 请求次数超过设定值或错误百分比超过设定值，会将断路器从关闭态转为开启态
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期，失败后等待该时间后尝试半开
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60") // 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("*****id不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号：" + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "id 不能为负数， 请稍后重试， id：" + id;
    }

}
