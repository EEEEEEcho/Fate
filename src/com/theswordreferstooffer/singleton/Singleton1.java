package com.theswordreferstooffer.singleton;

/**
 * 饿汉式单例模式，
 * 优点：类加载的时候创建一次实例，避免了多线程同步问题
 * 缺点：即使单例没被用到也会创建，浪费内存
 */
public class Singleton1 {
    private static Singleton1 singleton1 = new Singleton1();
    private Singleton1(){

    }
    public static Singleton1 getInstance(){
        return singleton1;
    }
}
