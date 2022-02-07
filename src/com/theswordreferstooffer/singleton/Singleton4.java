package com.theswordreferstooffer.singleton;

/**
 * 懒汉式：线程安全
 * 缺点：性能问题，添加了synchronized的函数比一般方法慢得多，若多次调用getInstance，则累积的性能损耗特别大。
 */
public class Singleton4 {
    private static Singleton4 singleton4 = null;
    private Singleton4(){

    }
    public static synchronized Singleton4 getInstance(){
        if(singleton4 == null){
            singleton4 = new Singleton4();
        }
        return singleton4;
    }
}
