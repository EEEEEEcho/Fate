package com.code.carl.dp;

public class ClimbStairs {
    public int climbStairs(int n) {
        //1.确定dp数组及其下标的含义
        //dp[i]表示爬到第i层时，有几种爬法
        int[] dp = new int[n + 1];
        //2.确定递推公式
        //当前的台阶可以从它的下一阶跳一步上来，也可以从它的下两阶跳两步上来
        //dp[i] = dp[i - 1] + dp[i - 2]
        //3.确定初始条件
        dp[1] = 1;  //第一层有一种方法
        if (n == 1) return dp[1];
        dp[2] = 2;  //第二层有两种方法
        if (n == 2) return dp[2];
        //4.确定遍历顺序，因为dp[i]依赖于dp[i-1]和dp[i-2]所以要从前向后推导
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
