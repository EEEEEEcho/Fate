package com.base.basics.qa;

public class Byte2Int {
    public static void main(String[] args) {
        /**
         * 可以做强制转换，但是 Java 中 int 是 32 位的，
         * 而 byte 是 8 位的，所以，如果强制转化是，
         * int 类型的高 24 位将会被丢弃，
         * byte 类型的范围是从 -128 到 127
         */
        int value = 127;
        byte byteValue = (byte) value;
        System.out.println(byteValue);  //127
        value = 128;
        byteValue = (byte) value;
        System.out.println(byteValue); //-128
        value = 130;
        byteValue = (byte) value;
        System.out.println(byteValue); //-126
    }
}
