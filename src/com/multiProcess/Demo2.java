package com.multiProcess;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Demo2 {
    public static ReentrantLock mainRoom = new ReentrantLock();
    public static Condition room1 = mainRoom.newCondition();
    public static Condition room2 = mainRoom.newCondition();
    public static boolean t1Flg = false;
    public static boolean t2Flg = false;
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            mainRoom.lock();
            try {
                while (!t1Flg){
                    try {
                        System.out.println("t1目前不符合条件");
                        room1.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t1符合条件继续运行");
            }
            finally {
                mainRoom.unlock();
            }
        },"t1");
        Thread t2 = new Thread(() -> {
            mainRoom.lock();
            try {
                while (!t2Flg){
                    System.out.println("t2目前不符合条件");
                    try {
                        room2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t2符合条件继续运行");
            }
            finally {
                mainRoom.unlock();
            }
        },"t2");

        Thread t3 = new Thread(() -> {
            mainRoom.lock();
            try {
                TimeUnit.SECONDS.sleep(3);
                t1Flg = true;
                room1.signalAll();
            }
            catch (Exception e){
                e.printStackTrace();
            }
            finally {
                mainRoom.unlock();
            }
        },"t3");

        Thread t4 = new Thread(() -> {
            mainRoom.lock();
            try {
                TimeUnit.SECONDS.sleep(2);
                t2Flg = true;
                room2.signalAll();
            }
            catch (Exception e){
                e.printStackTrace();
            }
            finally {
                mainRoom.unlock();
            }
        },"t4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
