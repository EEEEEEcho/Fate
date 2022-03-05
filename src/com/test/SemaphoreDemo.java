package com.test;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("hhhhhhh");
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    semaphore.release();
                }
            }).start();
        }
    }
}
