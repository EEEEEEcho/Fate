package com.code.carl.dp;

import java.util.Arrays;

public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1) return 1;
        //dp含义：dp[i]表示i之前包括i的以nums[i]结尾最长上升子序列的长度
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]){
                    dp[i] = Math.max(dp[j] + 1,dp[i]);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
