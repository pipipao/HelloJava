package muti_threads;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {
    public static void main(String[] args) {
        var counter=new RWLCounter();
        for (int i = 0; i < 5; i++) {
            var t=new Thread(){
                @Override
                public void run() {
                    super.run();
                    int index=(int)(Math.random()*10);
                    counter.inc(index);
                }
            };
            t.start();
//            try {
//                t.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }

        for (int i = 0; i < 100; i++) {
            var read=new Thread(){
                @Override
                public void run() {
                    super.run();
                    var result=counter.get();

                    for (var i : result) {
                        System.out.print(i);
                    }
                    System.out.println();
                }
            };
            read.start();
//            try {
//                read.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}

class RWLCounter {
    private final ReadWriteLock rwlock = new ReentrantReadWriteLock();
    private final Lock rlock=rwlock.readLock();
    private final Lock wlock=rwlock.writeLock();
    private int[] count=new int[10];

    public void inc(int index) {
        wlock.lock();
        try {
            count[index]++;
        } finally {
            wlock.unlock();
        }
    }

    public int[] get() {
        rlock.lock();
        try {
            return Arrays.copyOf(count,count.length);
        } finally {
            rlock.unlock();
        }
    }
}