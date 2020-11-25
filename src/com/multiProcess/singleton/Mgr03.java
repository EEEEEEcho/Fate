package com.multiProcess.singleton;

import java.util.concurrent.TimeUnit;

/**
 * 懒汉式：解决了 需要时才生产的问题。
 * 但是，带来了线程不安全性。
 * 线程并发执行时，可能同时执行到了判断是否为空的情况。这时，就会产生生成多个对象的问题
 * 可以通过synchronized来解决，但是会带来效率问题
 */
public class Mgr03 {
    private static Mgr03 INSTANCE;
    private Mgr03(){

    }
    public static synchronized Mgr03 getInstance(){
        if(INSTANCE == null){
            /**
             * 有人尝试使用细化锁粒度的办法来解决，但是这是不行的。
             * 细化的方法是，在判断为空后，在创建之前进行加锁，
             * 但是，可能会出现第一个线程判断为空了。然后加上了锁，这时候，第二个线程也判断为空了。
             * 在第一个线程创建完新的对象之后，第二个线程拿到锁，然后又创建了一遍。。。
             * 代码如下 蓝色注释
             */
//            synchronized (Mgr03.class){
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                }
//                catch (InterruptedException e){
//                    e.printStackTrace();
//                }
//                INSTANCE = new Mgr03();
//            }
            try {
                TimeUnit.SECONDS.sleep(1);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
            INSTANCE = new Mgr03();
        }
        return INSTANCE;
    }
    public void m(){
        System.out.println("mmmmmmmmmmm");
    }

    public static void main(String[] args) {
        for (int i = 0;i < 100;i ++){
            new Thread(()->{
                System.out.println(Mgr03.getInstance().hashCode());
            }).start();
        }
    }
}
