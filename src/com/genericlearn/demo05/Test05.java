package com.genericlearn.demo05;

public class Test05 {
    public static void main(String[] args) {
        Apple apple = new Apple();
        String key = apple.getKey();
        System.out.println(key);

        Orangle<String,Integer> orangle = new Orangle<>("Hello",9999);
        System.out.println(orangle.getKey());
        System.out.println(orangle.getValue());
    }
}
