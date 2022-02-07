package com.multiProcess.day01;

import java.util.concurrent.TimeUnit;

public class T08_Account {
    String name;
    double balance;

    //业务中给写方法加锁，读方法不加锁是否有问题？
    public synchronized void set(String name,double balance){
        this.name = name;   //先设置名字，之后两秒后设置值
        try{
            Thread.sleep(2000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        this.balance = balance;
    }
    public synchronized double getBalance(String name){
        return this.balance;
    }

    public static void main(String[] args) {
        T08_Account a = new T08_Account();
        //开个线程给zhangsan100块
        new Thread(()->{
            a.set("zhangsan",100.0);
        }).start();
        //睡一秒，看张三有多少钱
        try{
            TimeUnit.SECONDS.sleep(1);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(a.getBalance("zhangsan"));
        //睡两秒，看张三有多少钱
        try {
            TimeUnit.SECONDS.sleep(2);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(a.getBalance("zhangsan"));

        //整体程序运行效果： 因为给张三设置钱的时候要等两秒，所以第一次读，会读到0，脏读。
        //在主线程睡两秒之后再读才能读到给张三设置的钱

        //解决办法，给getAccount 也加上synchronized，但是加锁程序运行效率很低
        //为什么可以解决呢？ 就是因为给get方法加了锁，执行get方法时需要获得对象的锁 才可以执行，
        //但是先执行的set方法。set方法上了锁，在set没有释放锁之前，加了锁的get方法是没有办法执行的
        //只有获得了set方法结束后释放的锁 才可以执行
    }
}
