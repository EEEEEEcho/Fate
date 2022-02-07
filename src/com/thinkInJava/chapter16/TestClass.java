package com.thinkInJava.chapter16;

public class TestClass {
    public static class A{

    }
    public static class B{

    }

    public static void main(String[] args) {
        for(Class<?> type : TestClass.class.getClasses()){
            System.out.println(type.getSimpleName());
        }
    }
}
