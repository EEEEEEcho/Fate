package com.thinkInJava.chapter16;

public class BerylliumSphere {
    private static long counter;
    private final long id = counter ++;
    public String toString(){
        return "Sphere " + id;
    }
}
