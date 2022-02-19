package com.labuladong.chapter4.dynamic;

import java.util.Arrays;

public class CalculateMinimumHP {
    //我尽力了
    public int calculateMinimumHP1(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][][] dp = new int[m][n][2];
        if (dungeon[0][0] < 0){
            dp[0][0][0] = dungeon[0][0];
        }
        dp[0][0][1] = dungeon[0][0];
        for (int i = 1; i < m; i++) {
            if (dungeon[i][0] < 0){
                if (dp[i - 1][0][1] < 0){
                    dp[i][0][0] = dp[i - 1][0][0] + dungeon[i][0];
                    dp[i][0][1] = dp[i - 1][0][1] + dungeon[i][0];
                }
                else{
                    if (dp[i - 1][0][1] >= Math.abs(dungeon[i][0])){
                        dp[i][0][0] = dp[i - 1][0][0];
                        dp[i][0][1] += dungeon[i][0];
                    }
                    else{
                        dp[i][0][0] = dp[i - 1][0][0] + dp[i - 1][0][1] + dungeon[i][0];
                        dp[i][0][1] = dp[i - 1][0][1] + dungeon[i][0];
                    }
                }
            }
            else{
                if (dp[i - 1][0][1] > 0){
                    dp[i][0][0] = dp[i - 1][0][0];
                    dp[i][0][1] = dp[i - 1][0][1] + dungeon[i][0];
                }
                else{
                    dp[i][0][0] = dp[i - 1][0][0];
                    dp[i][0][1] = dungeon[i][0];
                }
            }
        }

        for (int i = 1; i < n; i++) {
            if (dungeon[0][i] < 0){
                if (dp[0][i - 1][1] < 0){
                    dp[0][i][0] = dp[0][i - 1][0] + dungeon[0][i];
                    dp[0][i][1] = dp[0][i - 1][1] + dungeon[0][i];
                }
                else{
                    if (dp[0][i - 1][1] > Math.abs(dungeon[0][i])){
                        dp[0][i][0] = dp[0][i - 1][0];
                        dp[0][i][1] += dungeon[0][i];
                    }
                    else{
                        dp[0][i][0] = dp[0][i - 1][0] + dp[0][i-1][1] + dungeon[0][i];
                        dp[0][i][1] = dp[0][i-1][1] + dungeon[0][i];
                    }
                }
            }
            else{
                if (dp[0][i - 1][1] > 0){
                    dp[0][i][0] = dp[0][i - 1][0];
                    dp[0][i][1] = dp[0][i - 1][1] + dungeon[0][i];
                }
                else{
                    dp[0][i][0] = dp[0][i - 1][0];
                    dp[0][i][1] = dungeon[0][i];
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int n1 = dp[i - 1][j][0];
                int h1 = dp[i - 1][j][1];

                int n2 = dp[i][j - 1][0];
                int h2 = dp[i][j - 1][1];

                int step = dungeon[i][j];
                if (step > 0){
                    if (n1 > n2){
                        dp[i][j][0] = n1;
                        dp[i][j][1] = h1 + dungeon[i][j];
                    }
                    else{
                        dp[i][j][0] = n2;
                        dp[i][j][1] = h2 + dungeon[i][j];
                    }
                }
                else{
                    if(h1 > 0){
                        if (h1 < Math.abs(step)){
                            n1 += h1 - Math.abs(step);
                        }
                        h1 -= Math.abs(step);
                    }
                    else {
                        h1 += step;
                        n1 += step;
                    }
                    if (h2 > 0){
                        if (h2 < Math.abs(step)){
                            n2 += h2 - Math.abs(step);
                        }
                        h2 -= Math.abs(step);
                    }
                    else{
                        h2 += step;
                        n2 += step;
                    }
                    if (n1 > n2){
                        dp[i][j][0] = n1;
                        dp[i][j][1] = h1;
                    }
                    else {
                        dp[i][j][0] = n2;
                        dp[i][j][1] = h2;
                    }
                }
            }
        }



//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(Arrays.toString(dp[i][j]) + " ");
//            }
//            System.out.println();
//        }
        return Math.abs(dp[m - 1][n - 1][0]) + 1;
    }

    //反向思考
    private int[][] memo;
    public int calculateMinimumHP(int[][] dungeon) {
        memo = new int[dungeon.length][dungeon[0].length];
        for (int[] row : memo){
            Arrays.fill(row,-1);
        }
        return dp(dungeon,0,0);
    }
    //从grid[i][j]到达终点，所需要的最少的生命值为dp(grid,i,j)
    public int dp(int[][] grid,int i,int j){
        int m = grid.length;
        int n = grid[0].length;
        if (i == m - 1 && j == n - 1){
            return grid[i][j] >= 0 ? 1 : -grid[i][j] + 1;
        }
        if (i >= m || j >= n){
            return Integer.MAX_VALUE;
        }
        if (memo[i][j] != -1){
            return memo[i][j];
        }
        int res = Math.min(dp(grid,i + 1,j),dp(grid,i,j + 1)) - grid[i][j];
        memo[i][j] = res <= 0 ? 1 : res;
        return memo[i][j];
    }



    public static void main(String[] args) {
        CalculateMinimumHP c = new CalculateMinimumHP();
        c.calculateMinimumHP(new int[][]{
                {1},
                {-2},
                {1}
        });

    }
}
