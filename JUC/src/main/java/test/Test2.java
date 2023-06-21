package test;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicStampedReference;

@Slf4j(topic = "c.Test2")
public class Test2 {

    volatile int a = 10;
    volatile static tt t;

    public static void main(String[] args) {
        Runnable r = () -> log.debug("running");
        Thread thread = new Thread(r, "t2");
        thread.start();
        t = new tt();
    }

    static class tt{

    }
}
