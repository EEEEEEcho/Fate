package com.proxyStudy.staticProxy;

public class StaticProxyTest {
    public static void main(String[] args) {
        Person zhangsan = new Student("张三");
        //将学生张三交给班长代理
        Person monitor = new StudentsProxy(zhangsan);

        //班长代理交班费
        monitor.giveMoney();
    }
}
