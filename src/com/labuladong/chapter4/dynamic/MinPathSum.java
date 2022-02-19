package com.labuladong.chapter4.dynamic;

import java.util.Arrays;

public class MinPathSum {
    //自底向上
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            dp[i][0] = sum + grid[i][0];
            sum = dp[i][0];
        }
        sum = 0;
        for (int i = 0; i < grid[0].length; i++) {
            dp[0][i] = sum + grid[0][i];
            sum = dp[0][i];
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j],dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    private int[][] memo;
    public int minPathSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (m == 1 && n == 1){
            return 0;
        }
        memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i],-1);
        }
        dp(grid,m - 1,n - 1);
        return memo[m - 1][n - 1];
    }

    public int dp(int[][] grid,int i,int j){
        if (i == 0 && j == 0){
            return grid[i][j];
        }
        if (i < 0 || j < 0){
            return Integer.MAX_VALUE;
        }
        if (memo[i][j] != -1){
            return memo[i][j];
        }
        memo[i][j] = Math.min(dp(grid,i - 1,j),dp(grid,i,j - 1)) + grid[i][j];
        return memo[i][j];
    }
}
