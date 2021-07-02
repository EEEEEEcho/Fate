package com.thinkInJava.chapter14;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理类，运行是创建一个代理对象，对被代理对象进行增强
 * 该类是代理人
 */
class DynamicProxyHandler implements InvocationHandler{
    /*被代理对象*/
    private Object proxied;

    public DynamicProxyHandler(Object proxied){
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //对被代理对象的方法进行增强
        System.out.println("对方法:" + method + "增强");
        System.out.println("**** proxy: " + proxy.getClass() + ", method: " + method + ", args: " + args);
        if (args != null){
            for(Object arg : args){
                System.out.println(" " + arg);
            }
        }
        System.out.println("对方法:" + method + "增强结束");
        //调用proixed的method方法，传入的方法参数为args
        return method.invoke(proxied,args);
    }
}

public class SimpleDynamicProxy {
    public static void consumer(Interface iface){
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        RealObject realObject = new RealObject();
        consumer(realObject);
        //插入动态代理，然后重新调用
        Interface proxy = (Interface) Proxy.newProxyInstance(
                Interface.class.getClassLoader(),
                new Class[]{Interface.class},
                new DynamicProxyHandler(realObject)
        );
        consumer(proxy);
    }
}
