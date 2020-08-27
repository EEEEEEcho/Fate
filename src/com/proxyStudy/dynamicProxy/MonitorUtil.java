package com.proxyStudy.dynamicProxy;

public class MonitorUtil {
    //用一个ThreadLocal存储方法调用的开始时间
    private static ThreadLocal<Long> tl = new ThreadLocal<>();

    public static void start(){
        tl.set(System.currentTimeMillis());
    }
    //结束时打印耗时
    public static void finish(String methodName){
        long finishTime = System.currentTimeMillis();
        System.out.println(methodName + " 方法耗时 " + (finishTime - tl.get()) + "ms");
    }
}
