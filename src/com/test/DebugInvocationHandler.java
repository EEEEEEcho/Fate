package com.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DebugInvocationHandler implements InvocationHandler {
    //要代理的真实对象
    private final Object target;
    //传入被代理的对象
    public DebugInvocationHandler(Object target) {
        this.target = target;
    }

    //动态代理对象调用 原生方法的时候，最终实际上是调用的invoke()方法
    //然后invoke()方法代替我们去调用了被代理对象的原生方法

    /**
     * @param proxy 动态生成的代理类
     * @param method 与代理类对象调用的方法相对应
     * @param args 当前method方法的参数
     * @return
     * @throws Throwable
     * 你通过Proxy 类的 newProxyInstance() 创建的代理对象在调用方法的时候，
     * 实际会调用到实现InvocationHandler 接口的类的 invoke()方法
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before Method : " + method.getName());
        //调用被代理对象中的方法
        Object result = method.invoke(target, args);
        System.out.println("After Method : " + method.getName());
        return result;
    }
}
