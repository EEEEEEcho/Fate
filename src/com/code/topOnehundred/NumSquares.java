package com.code.topOnehundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class NumSquares {

    public int numSquares(int n) {
        int t = 1;
        ArrayList<Integer> squares = new ArrayList<>();
        //先求出来从1到n的完全平方数
        while (t * t <= n){
            squares.add(t * t);
            t ++;
        }
        int m = squares.size();
        //dp数组的含义：
        //dp[i][j]代表，使用前i个完全平方数，凑出 j，所需要的最小的数量
        //dp[0][0] = 0,dp[0][x] = 无效
        int[][] dp = new int[m + 1][n + 1];
        Arrays.fill(dp[0],Integer.MAX_VALUE);
        dp[0][0] = 0;
        for (int i = 1; i <= m; i++) {
            //第i个完全平方数
            int x = squares.get(i - 1);
            for (int j = 1; j <= n; j++) {
                //最坏的情况，凑成j的全是1
                dp[i][j] = j;
                //有k中情况
                //不选第i个完全平方数:dp[i][j] = dp[i - 1]
                //选择第i个完全平方数1次:dp[i][j] = dp[i - 1][j - 1 * squares(i)] + 1
                //选择第i个完全平方数1次:dp[i][j] = dp[i - 1][j - 2 * squares(i)] + 2
                //选择第i个完全平方数k次:dp[i][j] = dp[i - 1][j - k * squares(i)] + k
                for (int k = 0; k * x <= j; k++) {
                    if(dp[i - 1][j - k * x] != Integer.MAX_VALUE){
                        dp[i][j] = Math.min(dp[i][j],dp[i - 1][j - k * x] + k);
                    }
                }
            }
        }
        return dp[m][n];
    }
    //状态压缩
    public int numSquares2(int n) {
        int[] f = new int[n + 1];
        Arrays.fill(f, 0x3f3f3f3f);
        f[0] = 0;
        for (int t = 1; t * t <= n; t++) {
            int x = t * t;
            for (int j = x; j <= n; j++) {
                f[j] = Math.min(f[j], f[j - x] + 1);
            }
        }
        return f[n];
    }
}
