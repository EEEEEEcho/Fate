package com.qiye;

import java.util.Scanner;

public class SectionExpress {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int array[] = new int[n];
        for(int i=0;i < n;i ++){
            array[i] = scanner.nextInt();
        }
        int sum = 1;
        for(int i=0;i < n - 1;i ++){
            if(array[i] + 1 != array[i + 1]){
                sum ++;
            }
        }
        System.out.println(sum);
    }
}
