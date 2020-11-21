package com.multiProcess.day01;

public class T04_ThreadState {
    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println(this.getState());
            for (int i=0;i < 1000;i ++){
                try {
                    Thread.sleep(500);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t = new MyThread();
        // 获取线程的状态
        System.out.println(t.getState());
        t.start();
    }
}
