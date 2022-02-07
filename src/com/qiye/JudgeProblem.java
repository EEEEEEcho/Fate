package com.qiye;

import java.util.Scanner;

public class JudgeProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int t = scanner.nextInt();
        int a = scanner.nextInt();
        int s = n - t;
        int b = n - a;
        int r1 = compare(a,t);
        int r2 = compare(s,b);
        System.out.println(r1 + r2);
    }
    public static int compare(int x,int y){
        if(x < y){
            return x;
        }
        return y;
    }
}
