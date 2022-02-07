package com.multiProcess.day01;

public class T05_Locked_Test {
    private int count = 10;             //这个count是临界资源
    private Object o = new Object();    // 这个o是锁对象

    public void m(){
        synchronized (o){   //任何线程执行下列代码，必须先拿到o锁
            count --;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }
}
