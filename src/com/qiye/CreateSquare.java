package com.qiye;

import java.util.Arrays;
import java.util.Scanner;

public class CreateSquare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows[] = new int[4];
        for(int i=0;i < 4;i ++){
            rows[i] = scanner.nextInt();
        }
        Arrays.sort(rows);
        int mid = (rows[1] + rows[2]) / 2;
        int result = 0;
        for(int i=0;i < 4;i ++){
            result += Math.abs(rows[i] - mid);
        }
        System.out.println(result);
    }
}
