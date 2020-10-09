package com.thinkInJava.chapter14;

import com.theswordreferstooffer.review.One;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class DynamicProxyHandler implements InvocationHandler{
    private Object proxied;
    public DynamicProxyHandler(Object proxied){
        this.proxied = proxied;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("**** proxy: " + proxy.getClass() + ", method: " + method +", args : " + args);
        if (args != null){
            for (Object arg : args){
                System.out.println(" " + arg);
            }
        }
        return method.invoke(proxied,args);
    }
}
public class SimpleDynamicProxy {
    public static void consumer(Interface iface){
        iface.doSomething();
        iface.somethingElse("banana");
    }

    public static void main(String[] args) {
        RealObject realObject = new RealObject();
        consumer(realObject);
        //通过调用静态方法Proxy.Proxy.newProxyInstance
        Interface proxy = (Interface) Proxy.newProxyInstance(
                                    Interface.class.getClassLoader(),
                                    new Class[]{Interface.class},
                                    new DynamicProxyHandler(realObject));
        consumer(proxy);

    }
}
