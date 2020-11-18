package muti_threads;

import java.util.ArrayList;
import java.util.concurrent.locks.StampedLock;

public class StampedLockTest {
    public static void main(String[] args) {
        final int N=10;
        var p=new Point();
        var moveList=new ArrayList<Thread>();
        var getList = new ArrayList<Thread>();

        for (int i = 0; i < N; i++) {
            var t=new Thread(new Runnable() {
                @Override
                public void run() {
                    var dx=Math.random()*5;
                    var dy=Math.random()*5;
                    p.move(dx,dy);
                }
            });
            moveList.add(t);
        }
        for (int i = 0; i < N; i++) {
            var t=new Thread(new Runnable() {
                @Override
                public void run() {
                    var distance=(int)p.distanceFromZero();
//                    System.out.println(distance);
                }
            });
            getList.add(t);
        }
        for (int i = 0; i < N; i++) {
            getList.get(i).start();
            moveList.get(i).start();
        }
    }
}
class Point{
    private final StampedLock stampedLock = new StampedLock();
    private double x;
    private double y;

    public void move(double dx, double dy) {
        long stamp=stampedLock.writeLock();
        try {
            x+=dx;
            y+=dy;
        } finally {
            stampedLock.unlock(stamp);
        }
    }

    public double distanceFromZero() {
        long stamp=stampedLock.tryOptimisticRead();
        boolean changed=false;
        double currentX=x;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        double currentY=y;
        if (!stampedLock.validate(stamp)) {
            changed=true;
            stamp=stampedLock.readLock();
            try {
                currentX=x;
                currentY=y;
            } finally {
                stampedLock.unlockRead(stamp);
            }
        }
        if (changed){
            System.out.println("changed");
        }else {
            System.out.println("unchanged");
        }
        return Math.sqrt(currentX*currentX+currentY*currentY);
    }
}
