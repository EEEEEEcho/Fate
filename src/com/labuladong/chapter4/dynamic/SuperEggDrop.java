package com.labuladong.chapter4.dynamic;

import java.util.Arrays;

public class SuperEggDrop {
    int[][] memo;
    public int superEggDrop(int k, int n) {
        memo = new int[k + 1][n + 1];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i],-1);
        }
        return dp(k, n);
    }
    //当前状态为k个鸡蛋，n层楼
    //返回这个状态下的最优结果
    public int dp(int k,int n){
        if (k == 1) return n;   //如果只有一个鸡蛋，那么
        if (n == 0) return 0;   //如果只有0层楼，那么直接返回0
        if (memo[k][n] != -1){
            return memo[k][n];
        }
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < n + 1; i++) {
            res = Math.min(
                    res,
                    Math.max(dp(k - 1,i  - 1),dp(k,n - i))
            );
        }
        memo[k][n] = res;
        return res;
    }
}
