package test;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "c.tea")
public class water {

    public static void main(String[] args) {

        Thread water = new Thread(() -> {
            log.debug("烧水");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("洗完了");
        }, "water");
        water.start();

        Thread tea1 = new Thread(() -> {
            log.debug("洗茶壶");
        }, "tea1");
        tea1.start();

        Thread tea2 = new Thread(() -> {
            log.debug("洗茶杯");
        }, "tea2");
        tea2.start();

        Thread tea3 = new Thread(() -> {
            log.debug("拿茶叶");
        }, "tea3");
        tea3.start();

    }

}
