package com.labuladong.chapter4.dynamic;

import java.util.Arrays;

public class MinFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int dp[][] = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0){
                    dp[i][j] = matrix[i][j];
                }
                else{
                    dp[i][j] = 200000;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int x = dp[i - 1][j];
                int y = 200000;
                int z = 200000;
                if (j - 1 >= 0){
                    y = dp[i - 1][j - 1];
                }
                if (j + 1 < matrix[0].length){
                    z = dp[i - 1][j + 1];
                }
                int min = Math.min(z,Math.min(x,y));
                dp[i][j] = min + matrix[i][j];
            }
        }
//        for (int i = 0; i < dp.length; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
        int ans = dp[dp.length - 1][0];
        for (int i = 0; i < dp[0].length; i++) {
            if (ans > dp[dp.length - 1][i]){
                ans = dp[dp.length - 1][i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MinFallingPathSum sum = new MinFallingPathSum();
        int i = sum.minFallingPathSum(new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}});
//        int i = sum.minFallingPathSum(new int[][]{{-19,57}, {-40,-5}});
        System.out.println(i);
    }
}
