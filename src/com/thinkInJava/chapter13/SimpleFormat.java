package com.thinkInJava.chapter13;

public class SimpleFormat {
    public static void main(String[] args) {
        int x = 5;
        double y = 5.33247;
        System.out.println("Row 1: [" + x + " " + y + "]");
        System.out.format("Row1 :[%d, %f]\n",x,y);
        System.out.printf("Row1 :[%d, %f]",x,y);
    }
}
