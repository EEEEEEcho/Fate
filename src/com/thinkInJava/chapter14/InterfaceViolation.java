package com.thinkInJava.chapter14;

public class InterfaceViolation {
    public static void main(String[] args) {
        A a = new B();
        a.f();
        System.out.println(a.getClass().getName());
        if(a instanceof B){ //这样是不对的
            B b = (B)a;
            b.g();
        }
    }
}
