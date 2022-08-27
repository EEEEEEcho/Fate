package com.code.EveryDay;

public class MinCost {
    public int minCost(int[][] costs) {
        //动态规划，当前已知前i个房子的最小花费成本时，根据粉刷第i + 1号房子的粉刷成本可以计算出
        //粉刷前i + 1个房子的成本
        if (costs == null || costs.length == 0) return 0;
        //dp[i][j]表示粉刷第0号房子到第i号房子，且第i号房子粉刷为第j个颜色时所需的最小成本
        int[][] dp = new int[costs.length][3];
        //初始化,粉刷第0号房子，粉刷成不同的颜色所需要的最小花费即第0号的花费
        for (int i = 0; i < 3; i++) {
            dp[0][i] = costs[0][i];
        }
        for (int i = 1; i < costs.length; i++) {
            //由于不能粉刷成相同的颜色，所以颜色要隔开
            dp[i][0] = Math.min(dp[i - 1][1],dp[i - 1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i - 1][0],dp[i - 1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i - 1][0],dp[i - 1][1]) + costs[i][2];
        }
        return Math.min(Math.min(dp[costs.length - 1][0],dp[costs.length - 1][1])
        ,dp[costs.length - 1][2]);
    }

}
