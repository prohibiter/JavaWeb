package test;

public class Test27 {


    public static void main(String[] args) {
        synchronized int i = 10;
        WaitNotify wn = new WaitNotify(1, 5);
        new Thread(() -> {
            wn.print("a", 1, 2);
        }).start();

        new Thread(()->{
            wn.print("b", 2, 3);
        }).start();

        new Thread(()->{
            wn.print("c", 3, 1);
        }).start();
    }

}

//锁控制对象
synchronized class WaitNotify {

    public void print(String str, int waitFlag, int nextFlag) {
        for (int i = 0; i < this.loop; i++) {
            synchronized (this) {
                while (waitFlag != flag) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(str);
                this.flag = nextFlag;
                this.notifyAll();
            }
        }
    }

    private int flag;
    private int loop;

    public WaitNotify(int flag, int loop) {
        this.flag = flag;
        this.loop = loop;
    }
}
