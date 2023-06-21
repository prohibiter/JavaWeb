package test;

import lombok.extern.slf4j.Slf4j;

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class Test20 {

    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < 3; i++){
            new People().start();
        }

        Thread.sleep(1000);
        for(Integer id : MailBoxes.getId()){
            new Postman(id,"内容" + id).start();
        }
    }

}

@Slf4j(topic = "c.People")
class People extends Thread{
    @Override
    public void run(){
        //收信
        GuardedObject guardedObject = MailBoxes.createGuardedObject();
        log.debug("收信id{}",guardedObject.getId());
        Object mail = guardedObject.get(5000);
        log.debug("收到信id:{}，内容：{}",guardedObject.getId(),mail);
    }
}

@Slf4j(topic = "c.Postman")
class Postman extends Thread{
    private int mailId;

    private String mail;

    public Postman(int mailId, String mail) {
        this.mailId = mailId;
        this.mail = mail;
    }

    @Override
    public void run(){
        GuardedObject guardedObject = MailBoxes.getGuardedObject(this.mailId);
        log.debug("收到信id:{}，内容：{}",guardedObject.getId(),mail);
        guardedObject.complete(mail);
    }
}

class MailBoxes{
    private static Map<Integer, GuardedObject> boxes = new Hashtable<>();

    public static int id = 1;

    private static synchronized int generatorId(){
        return id++;
    }

    public static synchronized GuardedObject createGuardedObject(){
        GuardedObject go = new GuardedObject(generatorId());
        boxes.put(go.getId(),go);
        return go;
    }

    public static GuardedObject getGuardedObject(int id){
        return boxes.remove(id);
    }

    public static Set<Integer> getId(){
        return boxes.keySet();
    }
}

class GuardedObject{
    private final int id;

    private Object object;

    public GuardedObject(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Object get(long timeout){
        synchronized (this) {
            long base = System.currentTimeMillis();
            long passedTime = 0;
            while(object == null){
                long need = timeout - passedTime;
                if(need < 0){
                    break;
                }
                try {
                    wait(need);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                passedTime = System.currentTimeMillis() - base;
            }
        }
        return object;
    }

    public void complete(Object object){
        synchronized (this){
            this.object = object;
            this.notifyAll();
        }
    }
}
