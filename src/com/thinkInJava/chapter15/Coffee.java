package com.thinkInJava.chapter15;

public class Coffee {
    private static long counter = 0;
    private final long id = counter ++;
    public String toString(){
        return getClass().getSimpleName()  + " " + id;
    }
}
