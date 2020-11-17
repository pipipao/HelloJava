package muti_threads;

public class CreateThreadTest {
    public static void main(String[] args) {
        Thread t=new MyThread();
        t.start();
        Thread t2=new Thread(new MyRunnable());
        t2.start();
        Thread thread = new Thread(()->{
            System.out.println("lambda");
        });
        thread.start();
    }
}
class MyThread extends Thread{
    @Override
    public void run() {
        super.run();
        System.out.println("New Thread extends Thread");
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Implements runnable");
    }
}