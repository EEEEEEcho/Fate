package com.qiye;

import java.util.Scanner;

public class AirTrival {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int array[] = new int[n];
        int count = 0;
        for(int i = 0;i < n;i ++){
            array[i] = scanner.nextInt();
            s -= array[i];
            if(s >= 0){
                count ++;
            }
            else{
                break;
            }
        }
        System.out.println(count);
    }
}
