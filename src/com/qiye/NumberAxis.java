package com.qiye;

import java.util.Arrays;
import java.util.Scanner;

public class NumberAxis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long step = scanner.nextLong();
        long array[] = new long[n];
        for(int i=0;i < n;i ++){
            array[i] = scanner.nextLong();
        }
        Arrays.sort(array);
        array[0] += step;
        for(int i=1;i < n;i ++){
            array[i] = array[i] -= step;
            if(array[i] <= array[i - 1]){
                array[i] = array[i - 1] + 1;
            }
        }
        System.out.println(array[array.length - 1] - array[0]);
    }
}
