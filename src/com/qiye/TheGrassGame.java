package com.qiye;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TheGrassGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while(n > 0) {
            long x = scanner.nextLong();
            if(x % 5 == 1 || x % 5 == 3 || x % 5 == 4){
                System.out.println("niu");
            }
            else {
                System.out.println("yang");
            }
            n --;
        }
    }
}
