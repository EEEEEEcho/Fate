package com.code.carl.dp;

import com.thinkInJava.chapter16.RandomGenerator;

import java.util.HashMap;

public class TryDemo {
    public static void main(String[] args) {
        try{
            int i = 1 / 0;
        }
        catch (ArithmeticException e){
            System.out.println("Hello");
            e.printStackTrace();
        }
    }
    static class MyKey{
        int code;
        int value;
    }
}
