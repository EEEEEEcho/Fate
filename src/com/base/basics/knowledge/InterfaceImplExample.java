package com.base.basics.knowledge;

import java.util.List;

public class InterfaceImplExample implements InterfaceExample{
    @Override
    public void func1() {
        System.out.println("实现的接口中的func1");
    }

    public static void main(String[] args) {
        InterfaceExample i = new InterfaceImplExample();
        i.func1();
        i.func2();
        System.out.println(InterfaceExample.x);
        System.out.println(InterfaceExample.z);
        //调用接口中定义的main方法
        InterfaceExample.main(args);
    }
}
