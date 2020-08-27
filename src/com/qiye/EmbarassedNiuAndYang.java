package com.qiye;

import java.util.Scanner;

public class EmbarassedNiuAndYang {
    public static final int max = 101;
    public static boolean marked[][] = new boolean[max][max];
    public static double memo[][] = new double[max][max];


    public static double DFS(int n,int m){
        if(m <= 0){
            return 0;
        }
        if(marked[m][n]){
            return memo[m][n];
        }
        double p1,p2,p3;
        p1 = 1.0 * n * (n - 1)/((n+m) * (n+m-1));
        p2 = 1.0 * 2 * m * n/((n+m) * (n+m-1));
        p3 = 1.0 * m * (m - 1)/((n+m) * (n+m-1));
        memo[n][m] = 1.0 * (1 + p2 * DFS(n + 1,m - 1) + p3 * DFS(n + 2,m - 2)) / (1 - p1);
        marked[n][m] = true;
        return memo[n][m];
    }
    public static double RoundDouble(double number){
        return (number > 0.0) ? (number + 0.5) : (number - 0.5);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        if(n <= 0 || m <= 0){
            return ;
        }
        double res = DFS(n,m);
        double resInt =RoundDouble(res * 10);
        //res = resInt / 10;
        System.out.println(Math.round(resInt) * 0.1d);
    }
}
