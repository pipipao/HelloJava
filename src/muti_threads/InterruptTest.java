package muti_threads;

public class InterruptTest {
    public static void main(String[] args) {
        var t=new HighThread();
        t.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
//            e.printStackTrace();
        }
        System.out.println("Main thread order highThread to interrput");
        t.interrupt();
        try {
            t.join();
        } catch (InterruptedException e) {
//            e.printStackTrace();
        }
        System.out.println("end");
    }
}

class HighThread extends Thread {
    @Override
    public void run() {
        super.run();
        var lowThread=new LowThread();
        lowThread.start();
        try {
            lowThread.join();
        } catch (InterruptedException e) {
//            e.printStackTrace();
        }
        System.out.println("HighThread order lowThread to interrupt");
        lowThread.interrupt();

    }
}

class LowThread extends Thread {
    @Override
    public void run() {
        super.run();
        int i = 0;
        while (!interrupted()) {
            i++;
            System.out.println(i + "LowThread");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
//                e.printStackTrace();
                System.out.println("LowThread Interrupted");
                break;
            }


        }
    }
}