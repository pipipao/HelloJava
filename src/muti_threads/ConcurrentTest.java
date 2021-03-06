package muti_threads;

public class ConcurrentTest {
    public static void main(String[] args) {
        Counter c = new Counter();
        System.out.println(c.getCount());
        for (int i = 0; i < 20; i++) {
            var t=new Thread(new Runnable() {
                @Override
                public void run() {
                    c.add(1);
                }
            });
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(c.getCount());
        for (int i = 0; i < 20; i++) {
            var t=new Thread(new Runnable() {
                @Override
                public void run() {
                    c.dec(1);
                }
            });
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        try {
//            Thread.sleep(20);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        System.out.println(c.getCount());


    }
}

class Counter {
    private int count = 0;

    public synchronized void add(int n) {
        this.count += n;
    }

    public void dec(int n) {
        synchronized (this) {
            this.count -= n;
        }
    }

    public int getCount() {
        return count;
    }
}