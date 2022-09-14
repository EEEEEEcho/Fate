package com.code.carl.dp;

import java.util.Arrays;

public class CanPartition {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;
        int weight = sum / 2;
        int[] dp = new int[weight + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = weight; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j],dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[weight] == weight;
    }
}
