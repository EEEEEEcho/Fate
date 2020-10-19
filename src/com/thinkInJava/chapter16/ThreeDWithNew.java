package com.thinkInJava.chapter16;

import java.util.Arrays;

public class ThreeDWithNew {
    public static void main(String[] args) {
        int[][][] a = new int[2][2][4];
        //deepToString方法将多维数组转换为多个String
        System.out.println(Arrays.deepToString(a));
    }
}
