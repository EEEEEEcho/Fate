package com.proxyStudy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        //创建一个实例对象，这个对象是被代理的对象
        Person zhangsan = new Student("张三");

        //创建一个与代理对象相关联的InvocationHandler  这个可以看作是一个中介类， 被代理的类的方法以及代理类要执行的方法
        //都在这个类中 然后通过Proxy创建一个代理 将中介类当做参数传入 执行被代理的方法
        InvocationHandler stuHandler = new StuInvocationHandler<Person>(zhangsan);
        //创建一个代理对象stuProxy来代理zhangsan，代理对象的每个执行方法都会替换执行Invocation中的invoke方法
        Person stuProxy = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(),
                new Class<?>[]{Person.class},stuHandler);
        //代理执行上交班费的方法
        stuProxy.giveMoney();
    }
}
