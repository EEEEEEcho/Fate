package com.labuladong.chapter4.dynamic;

import java.util.ArrayDeque;

public class Change {
    //完全背包问题
    public int change(int amount, int[] coins) {
        int m = coins.length + 1;
        int n = amount + 1;
        //dp数组的含义：使用前i个硬币，计算面额为j的值，有dp[i][j]种方法
        int[][] dp = new int[coins.length + 1][amount + 1];
        //使用前i个硬币，计算面额为0的值，都是1种方法
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (j - coins[i - 1] >= 0){
                    // 使用前i个硬币凑出面值j就等于：使用前i - 1种硬币凑出面值j的方法 + 使用前i种硬币，凑出面值（j - 第 i 个硬币的面值）的方法
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
                else {
                    //否则，使用前i个硬币凑出面值j就等于：使用前i - 1种硬币凑出面值j的方法.
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m - 1][n  - 1];
    }
    //压缩状态
    public int change2(int amount,int[] coins){
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i] >= 0){
                    dp[j] = dp[j] + dp[j - coins[i]];
                }
            }
        }
        return dp[dp.length - 1];
    }
    public static void main(String[] args) {
        Change c = new Change();
        c.change(5,new int[]{1,2,5});
    }
}
