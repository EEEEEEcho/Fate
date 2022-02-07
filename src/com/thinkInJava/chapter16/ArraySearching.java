package com.thinkInJava.chapter16;

import java.util.Arrays;
import java.util.Random;

public class ArraySearching {
    public static void main(String[] args) {
        Random random =new Random(47);
        Integer array[] = new Integer[100];
        for (int i=0;i < 100;i ++){
            array[i] = random.nextInt(100);
        }
        //二分查找
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        while (true){
            int r = array[random.nextInt(100)];;
            int location = Arrays.binarySearch(array,r);
            if(location >= 0){
                System.out.println("locaiton r:" + r + " at " + location);
                break;
            }
        }
    }
}
