package com.base.basics.qa;

public class DownTypeChange {
    public static void main(String[] args) {
        B b = new B();
        //可以向下转型，但可能会出现类型转换异常。
        //我的实验是直接转换异常
        C c = (C) new B();
        System.out.println(c);
    }
}
class A{

}
class B extends A{

}
class C extends B{

}