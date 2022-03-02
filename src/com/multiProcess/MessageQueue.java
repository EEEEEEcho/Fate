package com.multiProcess;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class MessageQueue<T> {
    private final LinkedList<T> list = new LinkedList<>();
    private int size;
    public MessageQueue(int size){
        this.size = size;
    }
    public T get(){
        synchronized (list){
            while (list.isEmpty()){
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            T poll = list.poll();
            list.notifyAll();
            return poll;
        }
    }
    public void set(T t){
        synchronized (this){
            while (list.size() == size){
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                list.offer(t);
                list.notifyAll();
            }
        }
    }
    static ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) throws Exception{
//        Thread t = new Thread(() -> {
//            LockSupport.park();
//
//            System.out.println("Hello");
//        });
//        t.start();
//        try {
//            TimeUnit.SECONDS.sleep(3);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        LockSupport.unpark(t);
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        lock.lock();
        try {
            condition1.await();
        }
        finally {
            lock.unlock();
        }
        //如果不调用lock.lock()加锁而是直接去调用condition.await()，就会报错
        condition1.signal();
        condition1.signalAll();
    }
}
