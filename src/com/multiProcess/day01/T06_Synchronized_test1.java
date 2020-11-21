package com.multiProcess.day01;

public class T06_Synchronized_test1 {

    private int count = 10;
    public synchronized void m(){
        // 这样在方法上加synchronized关键字，其实就是以当前类的对象为锁。拿到当前类的对象才算拿到锁
        count -- ;
        System.out.println(Thread.currentThread().getName() + " count= " + count);
    }
    public void m2(){
        //这种写法与上面的效果相同
        synchronized (this){
            count --;
            System.out.println(Thread.currentThread().getName() + " count= " + count);
        }
    }

    private static int count2 = 10;
    public static void m3(){
        synchronized (T06_Synchronized_test1.class){
            // 锁是T06_Synchronized_test1这个类的类对象（不是用该类生成的（new出来的）对象）
            count2 --;
            System.out.println(Thread.currentThread().getName() + "count = " + count2);
        }
    }
    public synchronized static void m4(){
        //这种synchronized static等同于synchronized (T06_Synchronized_test1.class)
        count2 --;
        System.out.println(Thread.currentThread().getName() + "count = " + count2);
    }
}
