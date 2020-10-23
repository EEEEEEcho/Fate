package com.thinkInJava.chapter16;

import java.util.Arrays;

public class ComparingArray {
    public static void main(String[] args) {
        int[] a1 = new int[10];
        int[] a2 = new int[10];
        Arrays.fill(a1,47);;
        Arrays.fill(a2,47);;
        System.out.println(Arrays.equals(a1,a2));
        a2[3] = 11;
        System.out.println(Arrays.equals(a1,a2));
        String[] s1 = new String[2];
        Arrays.fill(s1,"hi");
        String[] s2 = new String[]{
                new String("hi"),
                new String("hi")
        };
        System.out.println(Arrays.equals(s1,s2));
    }
}
