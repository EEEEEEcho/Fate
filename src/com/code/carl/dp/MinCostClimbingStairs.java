package com.code.carl.dp;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        //1.确定dp数组及其下标的含义
        //dp[i]表示爬上第i个台阶所需要的最小花费，其中当i = n时，到达了楼顶
        int[] dp = new int[n + 1];
        //2.确定递推公式
        //第i层，可以由第i - 1层跳上来，也可以从i - 2层跳上来，从i - 1层和i - 2层的花费中取最小的
        //dp[i] = Math.min(dp[i-1] + cost[i - 1],dp[i - 2] + cost[i - 2])
        //3.初始条件
        //第1层和第2层不需要花费
        dp[0] = dp[1] = 0;
        //4.遍历顺序。从前向后
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1],dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }
}
