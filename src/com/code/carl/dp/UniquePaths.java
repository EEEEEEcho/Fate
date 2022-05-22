package com.code.carl.dp;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        //1.确定dp数组及其下标的含义
        //dp[i][j]表示到达位置i，j时有多少条不同的路径
        int[][] dp = new int[m][n];
        //2.确定递推公式
        //到达一个格子只能从他前面或者上面下来,dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        //3.dp数组的初始化
        //第一行和第一列只能一直走所以dp[0][j] = 1,dp[i][0] = 1
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0;j < n;j ++){
            dp[0][j] = 1;
        }
        //4.确定遍历顺序。
        //从左到右，从上到下开始推
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m  - 1][n - 1];
    }
}
