package muti_threads;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class WaitAndNotifyTest {
    public static void main(String[] args) {
        var q=new TaskQueue();
        var ts = new ArrayList<Thread>();
        for (int i = 0; i < 5; i++) {
            var t=new Thread(){
                @Override
                public void run() {
                    System.out.println("Get thread start working");
                    while (true) {
                        try{
                            String s=q.getTask();
                            System.out.println("get"+s);
                        }catch (InterruptedException e){
                            
                            System.out.println("Get thread interrupted");
                            return;

                        }

                    }
                }
            };
            t.start();
            ts.add(t);
        }
        var add=new Thread(){
            @Override
            public void run() {
                super.run();
                for (int i = 0; i < 10; i++) {
                    String s=" Task"+Math.random();
                    q.addTask(s);
                    System.out.println("add"+s);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        add.start();
        try {
            add.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (var t:ts){
            t.interrupt();
        }

    }
}
class TaskQueue{
    Queue<String> queue = new LinkedList<>();

    public synchronized void addTask(String s) {
        this.queue.add(s);
        this.notifyAll();
    }

    public synchronized String getTask() throws InterruptedException {
        while (queue.isEmpty()) {
                this.wait();
        }
        return queue.remove();
    }
}