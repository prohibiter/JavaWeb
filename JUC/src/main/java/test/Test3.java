package test;

import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.LockSupport;

@Slf4j(topic = "c.Test3")
public class Test3 {
    public static void main(String[] args) throws Exception {
        FutureTask<Integer> task = new FutureTask<>(() -> {
            log.debug("running");
            Thread.sleep(100);
            return 100;
        });

        Thread t = new Thread(task,"t3");
        t.start();
        log.debug("{}",task.get());
    }
}
