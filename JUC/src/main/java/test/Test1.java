package test;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadPoolExecutor;

@Slf4j(topic = "c.Test1")
public class Test1 {
    public static void main(String[] args) {
        ThreadPoolExecutor
        Thread t = new Thread(() -> log.debug("running"));
        t.setName("t1");
        t.start();
        log.debug("main running");
    }
}
