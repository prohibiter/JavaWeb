package com.example.springcloud.controller;

import com.example.springcloud.entities.CommonResult;
import com.example.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.UUID;

@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, Payment> hashMap = new HashMap<Long, Payment>() {{
        this.put(1L, new Payment(1L, UUID.randomUUID().toString().replace("-", "")));
        this.put(2L, new Payment(2L, UUID.randomUUID().toString().replace("-", "")));
        this.put(3L, new Payment(3L, UUID.randomUUID().toString().replace("-", "")));
    }};

    @GetMapping("/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        Payment payment = hashMap.get(id);
        CommonResult<Payment> result = new CommonResult<>(200, "from mysql,server port: " + serverPort, payment);
        return result;
    }

}
