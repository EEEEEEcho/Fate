package com.multiProcess.day01;

import java.util.concurrent.TimeUnit;

/**
 * synchronized的可重入
 * 一个同步方法可以调用另外一个同步方法，一个线程已经拥有了某个对象的锁，再次申请的时候会得到该对象的锁
 * 也就是说：synchronized获得的锁是可重入的
 */
public class T09_Synchronized_test3 {
    synchronized void m1(){
        System.out.println("m1 start");
        try {
            TimeUnit.SECONDS.sleep(1);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        m2();   //调用同样需要锁的方法
        System.out.println("m1 end");
    }
    synchronized void m2(){
        //synchronized是可重入锁，
        //以这个为例，m1加了锁。而m2也加了锁。当起了一个线程调用m1时，会获得锁。但是
        //同时发现m1中调用了m2,m2也需要锁，但m1和m2是同一个线程调用的，线程已经有了m1的锁，所以可以调用m2
        try {
            TimeUnit.SECONDS.sleep(2);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("m2 end");
    }
}
