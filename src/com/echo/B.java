package com.echo;

public class B extends A {
    String t = "t2";

    public void Test2(){
        System.out.println("这是B-Test2" + t);
    }

    public static void main(String[] args) {
        A test = new B();
        test.Test2();
    }
}
