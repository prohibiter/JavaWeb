package test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

public class Test28 {

    public static void main(String[] args) {

        AwaitSignal as = new AwaitSignal(5);

        Condition a = as.newCondition();
        Condition b = as.newCondition();
        Condition c = as.newCondition();

        new Thread(()->{
            as.print("a",a,b);
        }).start();

        new Thread(()->{
            as.print("b",b,c);
        }).start();

        new Thread(()->{
            as.print("c",c,a);
        }).start();

        try {
            sleep(1000);
            as.lock();
            try{
                a.signalAll();
            }finally {
                as.unlock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class AwaitSignal extends ReentrantLock {
    private int loopNumber;

    public AwaitSignal(int loopNumber) {
        this.loopNumber = loopNumber;
    }

    /**
     * param1:输出内容
     * param2:进入哪个休息室
     * param3:下一间休息室
     */
    public void print(String str, Condition current, Condition nextCurrent) {
        for (int i = 0; i < loopNumber; i++) {
            this.lock();
            try {
                try {
                    current.await();
                    System.out.print(str);
                    nextCurrent.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                this.unlock();
            }
        }
    }
}
