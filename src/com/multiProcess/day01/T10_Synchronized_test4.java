package com.multiProcess.day01;

import java.util.concurrent.TimeUnit;

/**
 * //synchronized必须是可重入的，因为如果是子类继承了父类，而子类中新增了一个syn的方法去调用
 * 父类中的syn方法，如果synchronized是不可重入的，那么就会发生死锁。
 */
public class T10_Synchronized_test4 {
    synchronized void m1(){
        System.out.println("m start");
        try {
            TimeUnit.SECONDS.sleep(1);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new T10_Synchronized_test4_child().m2();
        new T10_Synchronized_test4_child().m1();
        //那么问题来了：父子类调用时，锁的是谁？
        //一定要记住synchronized锁的就是this
        //而子类中有指向父类的指针，所以锁的是子类，那个相应的指针也被加锁了
    }
}
class T10_Synchronized_test4_child extends T10_Synchronized_test4{
    synchronized void m2(){
        System.out.println("Children start");
        super.m1();
        System.out.println("Children end");
    }
    @Override
    synchronized void m1(){
        System.out.println("Children start");
        super.m1();
        System.out.println("Children end");
    }
}