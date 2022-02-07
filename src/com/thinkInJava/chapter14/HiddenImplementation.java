package com.thinkInJava.chapter14;

import java.lang.reflect.Method;

public class HiddenImplementation {
    public static void main(String[] args) throws Exception{
        A a = HiddenC.makeA();
        a.f();
        System.out.println(a.getClass().getName());

        callHiddenMethod(a,"u");
        callHiddenMethod(a,"v");
        callHiddenMethod(a,"w");
    }
    static void callHiddenMethod(Object a,String methodName) throws Exception{
        Method m = a.getClass().getDeclaredMethod(methodName);
        m.setAccessible(true);
        m.invoke(a);
    }
}
