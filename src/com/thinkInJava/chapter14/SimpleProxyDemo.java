package com.thinkInJava.chapter14;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.Arrays;
import java.util.Collections;

class RealObject implements Interface{
    //被代理对象
    @Override
    public void doSomething() {
        System.out.println("Do something");
    }

    @Override
    public void somethingElse(String str) {
        System.out.println("Something else " + str);
    }
}

class SimpleProxy implements Interface{
    //代理人
    private Interface proxied;  //被代理对象
    public SimpleProxy(Interface proxied){
        this.proxied = proxied;
    }
    @Override
    public void doSomething() {
        System.out.println("SimpleProxy do something");
        proxied.doSomething();
    }

    @Override
    public void somethingElse(String str) {
        System.out.println("SimpleProxy something else " + str);
        proxied.somethingElse(str);
    }
}

public class SimpleProxyDemo {

    public static void consumer(Interface iface){
        iface.doSomething();
        iface.somethingElse("BOBODA");
    }

    public static void main(String[] args) {
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
    }
}
