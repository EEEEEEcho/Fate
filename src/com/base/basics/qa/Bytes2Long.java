package com.base.basics.qa;

public class Bytes2Long {
    public static void main(String[] args) {
//        Long l = 1024l;
        byte[] bytes = {97, 23};
        String byteStr = new String(bytes);
        System.out.println(byteStr);
        long l1 = Long.parseLong(byteStr);
        System.out.println(l1);
    }
}
