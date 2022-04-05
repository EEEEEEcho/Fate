package com.code.ProxyDemo;



import java.lang.reflect.Proxy;

public class MainClass {
    public static void main(String[] args) {
        SmsServiceImpl target = new SmsServiceImpl();
        SmsService service = (SmsService)Proxy.newProxyInstance(target.getClass().getClassLoader(),// 目标类的类加载
                target.getClass().getInterfaces(),// 代理需要实现的接口，可指定多个
                new SmsHandler(target));
        service.send("Hello world");
    }
}
