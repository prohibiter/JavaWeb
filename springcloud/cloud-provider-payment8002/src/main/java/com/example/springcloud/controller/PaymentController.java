package com.example.springcloud.controller;

import com.example.springcloud.entities.CommonResult;
import com.example.springcloud.entities.Payment;
import com.example.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*********插入结果：" + result);
        if (result > 0) {
            return new CommonResult(200, "插入成功！serverPort：" + serverPort, result);
        }
        return new CommonResult(444, "插入失败！serverPort：" + serverPort, null);
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult create(@PathVariable("id") Long id) {
        Payment result = paymentService.getPaymentById(id);
        log.info("*********查询结果：" + result);
        if (result != null) {
            return new CommonResult(200, "查询成功！serverPort：" + serverPort, result);
        }
        return new CommonResult(444, "查询失败！serverPort：" + serverPort, null);
    }

    @GetMapping("/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("******service: " + service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }

        return this.discoveryClient;
    }

    @GetMapping("/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }
}
