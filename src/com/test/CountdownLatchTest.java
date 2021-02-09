package com.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountdownLatchTest {
    public static void main(String[] args) {
        //线程池
        ExecutorService service = Executors.newCachedThreadPool();
        //下达的命令。设置为1，一旦下达命令，值变为0，所有线程开始执行任务
        final CountDownLatch cdOrder = new CountDownLatch(1);
        //因为有三个战士，所以初始值为3，每一个战士执行任务完毕则cutDown一次，
        // 当三个都执行完毕，变为0，则指挥官停止等待。
        final CountDownLatch cdAnswer = new CountDownLatch(3);
        for(int i=0;i < 3;i ++){
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("线程" + Thread.currentThread().getName() + "准备接收命令");
                        cdOrder.await();    //战士们都处于等待状态
                        System.out.println("线程" + Thread.currentThread().getName() + "已经接受命令");
                        Thread.sleep((long) (Math.random() * 10000));
                        System.out.println("线程" + Thread.currentThread().getName() + "回应处理结果");
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    finally {
                        cdAnswer.countDown();
                    }
                }
            };
            service.execute(runnable);
        }
        try{
            Thread.sleep((long)(Math.random()*10000));
            System.out.println("线程" + Thread.currentThread().getName() + "即将发布命令");
            //发送命令，cdOrder减一，处于等待的战士们停止等待转去执行任务
            cdOrder.countDown();
            System.out.println("线程" + Thread.currentThread().getName() + "已经发送命令，正在等待结果");
            cdAnswer.await();
            System.out.println("线程" + Thread.currentThread().getName() + "已经收到所有响应结果");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {

        }
        //任务结束，停止线程池的所有线程
        service.shutdown();
    }
}
