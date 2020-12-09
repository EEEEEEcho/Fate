package com.leetCode.BitMultiplication;

import java.util.Arrays;

public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        s = s + t;
        char[] array = s.toCharArray();
        int tmp = array[0];
        for(int i = 1; i < array.length;i ++){
            tmp = tmp ^ array[i];
        }
        return (char)tmp;
    }

    public static void main(String[] args) {
        FindTheDifference f = new FindTheDifference();
        f.findTheDifference("abcd","abcde");
        //System.out.println(99 & 99);
        int[] array = {12,12,13};
        int tmp = array[0];
        for(int i=1;i < array.length;i ++){
            tmp ^= array[i];
        }
        System.out.println(tmp);
    }
}
