package com.example.springcloud.myHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.springcloud.entities.CommonResult;
import com.example.springcloud.entities.Payment;

public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult(444, "自定义通用处理器1");
    }

    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(444, "自定义通用处理器2");
    }

}
