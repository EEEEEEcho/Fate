package com.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        AtomicIntegerDemo aid = new AtomicIntegerDemo();
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(new PrintTask(aid));
            list.add(thread);
            thread.start();
        }
        for(Thread t : list){
            t.join();
        }
        System.out.println(aid.getCount());
    }
}
class AtomicIntegerDemo{
    private Integer ac = 0;
    public void increment(){
        int i = ac++;
        System.out.println(Thread.currentThread() + ":" + i);
    }
    public Integer getCount(){
        return ac;
    }
}
class PrintTask implements Runnable{
    AtomicIntegerDemo aid;
    public PrintTask(AtomicIntegerDemo aid){
        this.aid = aid;
    }

    @Override
    public void run() {
        this.aid.increment();
    }
}