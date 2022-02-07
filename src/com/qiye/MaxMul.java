package com.qiye;

import java.util.Arrays;
import java.util.Scanner;

public class MaxMul {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long array[] = new long[n];
        for(int i=0;i < n;i ++){
            array[i] = scanner.nextInt();
        }
        Arrays.sort(array);
        if(array[array.length - 1] < 0 || array[0] > 0){
            System.out.println(array[array.length - 1] * array[array.length - 2] * array[array.length - 3]);
        }
        else{
            long max = array[array.length - 1] * array[array.length - 2] * array[array.length - 3];
            if(max > array[0] * array[1] * array[array.length - 1]){
                System.out.println(max);
            }
            else {
                System.out.println(array[0] * array[1] * array[array.length - 1]);
            }
        }
    }
}
