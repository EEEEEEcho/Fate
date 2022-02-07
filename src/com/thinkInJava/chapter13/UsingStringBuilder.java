package com.thinkInJava.chapter13;

import java.util.Random;

public class UsingStringBuilder {
    public static Random random = new Random(47);
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder("[");
        for(int i=0;i < 25;i ++){
            stringBuilder.append(random.nextInt(100));
            stringBuilder.append(", ");
        }
        stringBuilder.delete(stringBuilder.length() - 2,stringBuilder.length());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        UsingStringBuilder usb = new UsingStringBuilder();
        System.out.println(usb);
    }
}
