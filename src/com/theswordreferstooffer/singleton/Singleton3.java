package com.theswordreferstooffer.singleton;

/**
 * 懒汉式：非线程安全
 *优点：需要时才去创建
 * 缺点：没有考虑线程安全问题，多个线程并发调用getInstance，可能会创建多个实例
 */
public class Singleton3 {
    private static Singleton3 singleton3 = null;
    private Singleton3(){

    }
    public static Singleton3 getInstance(){
        if(singleton3 == null){
            singleton3 = new Singleton3();
        }
        return singleton3;
    }
}
