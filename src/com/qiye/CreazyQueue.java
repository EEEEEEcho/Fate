package com.qiye;

import java.util.*;

public class CreazyQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int array[] = new int[n];
        for(int i=0;i < n;i ++){
            array[i] = scanner.nextInt();
        }
        Arrays.sort(array);
        if(n == 1){
            System.out.println(0);
        }
        if(n == 2){
            System.out.println(Math.abs(array[1] - array[0]));
        }
        if(n == 3){
            int a = Math.abs(array[1] - array[0]);
            int b = Math.abs(array[2] - array[0]);
            System.out.println(a + b);
        }
        else{
            int sum = Math.abs(array[n - 1] - array[0]) + Math.abs(array[n - 2] - array[0]);
            int index = n;
            for(int i = 1,j = index - 1;i <= index - 1 && j-2 >= i;i ++,j --){
                sum += array[j] - array[i];
                sum += array[j - 2] - array[i];
            }
            System.out.println(sum);
        }
    }
}
