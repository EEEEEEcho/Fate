package com.code.topOnehundred;

public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (j - 1 >= 0 && i - 1 >= 0){
                    dp[i][j] = Math.min(dp[i][j - 1],dp[i - 1][j]) + grid[i][j];
                }
                else if (j - 1 >= 0){
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                }
                else if(i - 1 >= 0){
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                }
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        MinPathSum minPathSum = new MinPathSum();
        int i = minPathSum.minPathSum(new int[][]{
                {1, 3, 1}, {1, 5, 1}, {4, 2, 1}
        });
        System.out.println(i);
    }
}
