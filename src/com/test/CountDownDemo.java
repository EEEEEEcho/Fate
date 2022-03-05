package com.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class CountDownDemo {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        CountDownLatch ct = new CountDownLatch(2);
        pool.submit(() -> {
            System.out.println("t1 start");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t1 end");
            ct.countDown();
        });
        pool.submit(() -> {
            System.out.println("t2 start");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2 end");
            ct.countDown();
        });
        pool.submit(() -> {
            System.out.println("t3 start");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t3 end");
            try {
                ct.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t3 等到了所有结束");
        });
    }
}
