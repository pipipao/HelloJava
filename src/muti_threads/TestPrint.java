package muti_threads;

public class TestPrint {
    public static void main(String[] args) {
        Object obj=new Object();
        Thread t=new Thread(new PrintChar(obj));
        Thread k=new Thread(new PrintNum(obj));
        t.start();
        k.start();

    }
}

class PrintNum implements Runnable{
    private Object object;

    public PrintNum(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        synchronized (object){
            for (int i=0;i<26;i++){
                System.out.println(i);
                if(i%2==0){
                    object.notifyAll();
                    try{
                        object.wait();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }

        }
    }
}

class PrintChar implements Runnable{
    private Object object;

    public PrintChar(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        synchronized (object){
            for (int i=65;i<=90;i++){
                System.out.println((char)i);
                object.notifyAll();
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}