package muti_threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService es= Executors.newFixedThreadPool(4);
        for (int i = 0; i < 6; i++) {
            es.submit(new Task("" + i));
        }
        es.shutdown();


    }
}
class Task implements Runnable{
    private final String name;

    Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Task "+name+" started");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
        System.out.println("end task"+name);
    }
}