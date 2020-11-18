package muti_threads;

public class JoinTest {
    public static void main(String[] args) {
        var printA=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("AAA++ "+i);
                }
            }
        });
        var printB=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("BBB   "+i);
                }
            }
        });
        printA.start();
        try {
            printA.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        printB.start();
    }
}
