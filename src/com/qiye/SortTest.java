package com.qiye;

import java.util.Arrays;
import java.util.Scanner;

public class SortTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int array[] = new int[n];
        int compare[] = new int[n];
        for(int i=0;i < n;i ++){
            array[i] = scanner.nextInt();
            compare[i] = array[i];
        }
        Arrays.sort(array);
//        for(int i = 0;i < array.length;i ++){
//            System.out.print(array[i] + " ");
//        }
//        System.out.println();
//        for(int i=0; i < array.length;i ++){
//            System.out.print(compare[i] + " ");
//        }
        int count = 0;
        for(int i=0;i < array.length;i ++){
            if(compare[i] != array[i]){
                count ++;
            }
        }
        System.out.println(count);
    }
}
