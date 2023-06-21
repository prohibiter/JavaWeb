package test;

import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.util.Comparator;
import java.util.LinkedList;

@Slf4j(topic = "c.Test21")
public class Test21 {

    public static void main(String[] args) {
        MessageQueue messageQueue = new MessageQueue(2);
        //生产者
        for (int i = 0; i < 3; i++) {
            int id = i;
            new Thread(() -> {
                messageQueue.put(new Message(id, "内容" + id), 2000);
            }, "生产者" + i).start();
        }

        //消费者
        new Thread(() -> {
            while (true) {
                Message take = messageQueue.take(2000);
                log.debug("消费消息{}", take.toString());
            }
        }, "消费者").start();
    }

}

@Slf4j(topic = "c.queue")
class MessageQueue {
    private static LinkedList<Message> list = new LinkedList<>();
    private int capacity;

    public MessageQueue(int capacity) {
        this.capacity = capacity;
    }

    public Message take(long timeout) {
        synchronized (list) {
            long base = System.currentTimeMillis();
            long passedTime = 0;
            while (list.isEmpty()) {
                long need = timeout - passedTime;
                if (need == 0) {
                    break;
                }
                try {
                    log.debug("队列为空，等待");
                    list.wait(need);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                passedTime = System.currentTimeMillis() - base;
            }
            Message message = list.removeFirst();
            log.debug("已消费消息{}", message);
            list.notifyAll();
            return message;
        }
    }

    public void put(Message message, long timeout) {
        synchronized (list) {
            long base = System.currentTimeMillis();
            long passedTime = 0;
            while (list.size() == capacity) {
                long need = timeout - passedTime;
                if (need < 0) {
                    break;
                }
                try {
                    log.debug("队列已满，等待");
                    list.wait(need);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                passedTime = System.currentTimeMillis() - base;
            }
            list.add(message);
            log.debug("已生产消息{}", message);
            list.notifyAll();
        }
    }

}

final class Message {
    private int id;
    private Object value;

    public Message(int id, Object value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", value=" + value +
                '}';
    }
}