package muti_threads;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    public static void main(String[] args) {
        RLockCounter counter=new RLockCounter();
        for (int i=0;i<40;i++){
            Thread t=new Thread(new Runnable() {
                @Override
                public void run() {
                    counter.add(1);
                }
            });
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        for (int i=0;i<40;i++){
            Thread t=new Thread(new Runnable() {
                @Override
                public void run() {
                    counter.dec(1);
                }
            });
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(counter.getCount());
    }
}
class RLockCounter{
    private final Lock lock = new ReentrantLock();
    private int count;

    public void add(int n) {
        lock.lock();
        try {
            count+=n;
        }finally {
            lock.unlock();
        }
    }
    public void dec(int n){
        try {
            if (lock.tryLock(1, TimeUnit.SECONDS)){
                count-=n;
            }
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getCount() {
        return count;
    }
}