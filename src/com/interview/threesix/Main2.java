package com.interview.threesix;

import java.util.Map;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < testCases; i++) {
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            scanner.nextLine();
            int[][] matrix = new int[row][col];
            for (int j = 0; j < row; j++) {
                for (int k = 0; k < col; k++) {
                    matrix[j][k] = scanner.nextInt();
                }
                scanner.nextLine();
            }
            if(row == 1 && col == 1) {
                System.out.println(Math.max(matrix[0][0], 0));
            }
            else{
                int ans = solve(matrix,row,col);
                System.out.println(ans);
            }
        }

    }
    public static int solve(int[][] a,int row,int col){
        int[][] dp = new int[row + 1][col + 1];
        int[][] preSum = new int[row + 1][col + 1];
        int maxSum = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                preSum[i + 1][j + 1] = preSum[i][j + 1] + preSum[i + 1][j] - preSum[i][j] + a[i][j];
                if (a[i][j] >= 0){
                    int minA = Math.min(dp[i][j], dp[i + 1][j]);
                    minA = Math.min(minA,dp[i][j + 1]);
                    dp[i + 1][j + 1] = minA + 1;
                }
                else {
                    dp[i + 1][j + 1] = 0;
                }
                int x = dp[i + 1][j + 1];
                maxSum = Math.max(maxSum,squire(preSum,i + 1,j + 1,i + 1 - x,j + 1 - x));
            }
        }
        return maxSum;
    }
    public static int squire(int[][] preSum,int i,int j,int k,int l){
        return preSum[i][j] - preSum[i][l] - preSum[k][j] + preSum[k][l];
    }
}
