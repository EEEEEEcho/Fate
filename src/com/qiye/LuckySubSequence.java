package com.qiye;

import java.util.*;

public class LuckySubSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] array = new long[n];
        for(int i=0;i < n;i ++){
            long x = scanner.nextLong();
            if(array[array.length - 1] != x){
                array[i] = x;
            }
        }
        long max = 0;
        for(int i = 0;i < array.length;i ++){
            for(int j= i-1;j >=0; j--){
                if(array[j] > array[i]){
                    long tmp = array[j] ^ array[i];
                    if(tmp > max){
                        max = tmp;

                    }
                    break;
                }
            }
            for(int j = i+1;j < array.length;j ++){
                if(array[j] > array[i]){
                    long tmp = array[j] ^ array[i];
                    if(tmp > max){
                        max = tmp;
                    }
                    break;
                }
            }
        }
        System.out.println(max);
    }
}
