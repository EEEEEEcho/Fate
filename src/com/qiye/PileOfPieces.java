package com.qiye;

import java.util.Arrays;
import java.util.Scanner;

public class PileOfPieces {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x[] = new int[n];
        int y[] = new int[n];
        for(int i=0;i < n;i ++){
            x[i] = scanner.nextInt();
        }
        scanner.nextLine();
        for(int i=0;i < n;i ++){
            y[i] = scanner.nextInt();
        }
        Arrays.sort(x);
        Arrays.sort(y);
        int centerX = (x[n/2 - 1] + x[n / 2]) / 2;
        int centerY = (y[n/2 - 1] + y[n / 2]) / 2;
        int result = 0;
        for(int i=0;i < n;i ++){
            result += Math.abs(x[i] - centerX) + Math.abs(y[i] - centerY);
        }
        System.out.println(result);
    }
}
