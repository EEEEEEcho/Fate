package com.thinkInJava.chapter16;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Reverse {
    public static void main(String[] args) {
        Random random =new Random(47);
        Integer array[] = new Integer[10];
        for (int i=0;i < 10;i ++){
            array[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(array));
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        //必须是包装类
        Arrays.sort(array,Collections.reverseOrder());
        System.out.println(Arrays.toString(array));
    }
}
