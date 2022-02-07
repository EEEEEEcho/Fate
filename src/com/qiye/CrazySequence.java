package com.qiye;

import java.util.Scanner;

public class CrazySequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long x = scanner.nextLong();
        long i= 1;
        long sum = 0;
        while (true){
            if(x <= sum){
                break;
            }
            sum += i;
            i ++;
        }
        System.out.println(i - 1);
    }
}
