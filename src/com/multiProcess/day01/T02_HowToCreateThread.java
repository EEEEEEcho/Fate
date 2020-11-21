package com.multiProcess.day01;

public class T02_HowToCreateThread {
    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("Hello myThread");
        }
    }
    static class MyRun implements Runnable{
        @Override
        public void run() {
            System.out.println("Hello MyRun");
        }
    }

    public static void main(String[] args) {
        new MyThread().start();
        new Thread(new MyRun()).start();    //使用runnable时，一定要将其作为Thread的构造函数参数传入。
        new Thread(()-> System.out.println("Hello lambda!")).start();
        /**
         * 启动线程的三种方式：
         * 1.继承Thread
         * 2.实现Runnable接口
         * 3.使用线程池启动线程 Executors.newCachedThread
         */
    }
}
