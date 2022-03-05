package com.test;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GameDemo {
    public static void main(String[] args) throws InterruptedException {
        //10个线程，代表10个玩家
        ExecutorService pool = Executors.newFixedThreadPool(10);
        //数组中的每个元素代表每个线程的加载进度
        String[] process = new String[10];
        //随机睡眠的时间
        Random random = new Random();
        //计数器锁
        CountDownLatch latch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            int k = i;  // lambda表达式中，不能引用外部的变量，所以需要定义一个常量在这里，
            pool.execute(()->{
                for (int j = 0; j <= 100; j++) {
                    process[k] = j + "%";
                    try {
                        //模拟加载延迟
                        TimeUnit.MILLISECONDS.sleep(random.nextInt(100));
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    //将打印改为print并在前面加上\r会使后面的结果覆盖前面的结果打印。
                    System.out.print("\r" + Arrays.toString(process));
                }
                //计数完成，计数器锁减一
                latch.countDown();
            });
        }
        latch.await();
        System.out.println("\n欢迎来到英雄联盟");
        pool.shutdown();
    }
}
