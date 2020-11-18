package muti_threads;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {
    public static void main(String[] args) {
        var q=new ConditionTaskQueue();
        var tl = new ArrayList<Thread>();
        for (int i = 0; i < 5; i++) {
            var t=new Thread(){
                @Override
                public void run() {
                    super.run();
                    try {
                        var s=q.getTask();
                        System.out.println("Get "+s);
                    } catch (InterruptedException e) {
//                        e.printStackTrace();
                        System.out.println("Get thread is interrupted");
                    }

                }
            };
            t.start();
//            try {
//                t.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            tl.add(t);

        }

        var addThread=new Thread(){
            @Override
            public void run() {
                super.run();
                for (int i = 0; i < 5; i++) {
                    var s="Task-"+Math.random();
                    q.addTask(s);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        addThread.start();
        try {
            addThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class ConditionTaskQueue{
    private final Lock lock = new ReentrantLock();
    private final Condition condition=lock.newCondition();
    private Queue<String> queue = new LinkedList<>();

    public void addTask(String s) {
        lock.lock();
        try {
            queue.add(s);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public String getTask() throws InterruptedException{
        lock.lock();
        try {
            while (queue.isEmpty()) {
                condition.await();
            }
            return queue.remove();
        } finally {
            lock.unlock();

        }
    }
}