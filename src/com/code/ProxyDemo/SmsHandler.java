package com.code.ProxyDemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SmsHandler implements InvocationHandler {
    //被代理对象
    private final Object object;

    public SmsHandler(Object target){
        this.object = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before method : " + method.getName());
        //调用被代理对象的方法
        Object result = method.invoke(object,args);
        System.out.println("After method : " + method.getName());
        return result;
    }
}
