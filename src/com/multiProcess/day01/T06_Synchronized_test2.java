package com.multiProcess.day01;

public class T06_Synchronized_test2 implements Runnable{

    private int count = 100;

    public synchronized void run(){
        /**
         * 加了synchronized 就没有必要加 volite,
         * 因为synchronized 既保证了可见性，也保证了原子性
         */
        count --;
        System.out.println(Thread.currentThread().getName() + "count = " + count);
    }


    public static void main(String[] args) {
        T06_Synchronized_test2 test2 = new T06_Synchronized_test2();
        for(int i = 0;i < 100;i ++){
            new Thread(test2,"Thread" + i).start();
        }
    }
}
