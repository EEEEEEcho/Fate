package com.multiProcess.day01;

/**
 * 同步方法和非同步方法是否可以同时调用？
 * 当然可以，因为非同步方法不需要获得锁
 */
public class T07{

    public synchronized void m1(){
        System.out.println(Thread.currentThread().getName() + "m1 start ...");
        //m2();
        try{
            Thread.sleep(10000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m1 end");
    }
    public void m2(){
        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m2 ");
    }

    public static void main(String[] args) {
        T07 t07 = new T07();
        new Thread(t07::m1,"t1").start();
        new Thread(t07::m2,"t2").start();
    }
}
