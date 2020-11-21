package com.multiProcess.day01;

import java.util.concurrent.TimeUnit;

/**
 * 程序在执行过程中出现异常，默认情况，锁是会释放的
 * 这时候，如果有其他线程等待进入出了异常的方法，就会直接进去了，得到了执行的机会。
 */
public class T11_Synchronized_test5 {
    int count = 0;
    synchronized void m(){
        System.out.println(Thread.currentThread().getName() + " start");
        while (true){
            count ++;
            System.out.println(Thread.currentThread().getName() + "count = " + count);
            try {
                TimeUnit.SECONDS.sleep(1);;
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
            if(count == 5){
                int i = 1 / 0;  //此处将会抛异常，锁将被释放，如果不想被释放。可以进行catch，然后循环继续
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        T11_Synchronized_test5 t = new T11_Synchronized_test5();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                t.m();
            }
        };
        new Thread(r,"t1").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(r,"r2").start();
    }
}
