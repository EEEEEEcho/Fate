package com.thinkInJava.chapter17;

public class StringHashCode {
    public static void main(String[] args) {
        String[] strings = "Hello Hello".split(" ");
        //如果程序中有多个String对象，且这些String对象都包含相同的字符序列，那么这些String对象都映射到同一内存区域
        System.out.println(strings[0].hashCode());
        System.out.println(strings[1].hashCode());
        //对于String而言，hashCode()明显是基于String的内容的
    }
}
