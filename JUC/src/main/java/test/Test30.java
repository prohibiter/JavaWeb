package test;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Test30 {
    public static void main(String[] args) throws Exception {
        final Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        Executors
    }
}

class MyAtomicInteger {
    private volatile int value;
    private static final long valueOffset;
    private static final Unsafe UNSAFE;

    static {
        final Field theUnsafe;
        try {
            theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            try {
                UNSAFE = (Unsafe) theUnsafe.get(null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                throw new Error(e);
            }
            try {
                valueOffset = UNSAFE.objectFieldOffset(MyAtomicInteger.class.getDeclaredField("value"));
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public int getValue() {
        return this.value;
    }

    public void decrement(int account) {
        while (true) {
            int prev = this.value;
            int next = prev - account;
            if (UNSAFE.compareAndSwapInt(this, valueOffset, prev, next)) {
                break;
            }
        }
    }
}
