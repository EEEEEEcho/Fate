package com.code.carl.dp;

public class CombinationSum4 {
    public int combinationSum4(int[] nums, int target) {
        //dp[i]表示凑成目标整数i的排列数为dp[i]
        int[] dp = new int[target + 1];
        dp[0] = 1;
        //先遍历物品，后遍历重量求的是组合数
        //先遍历重量，后遍历物品求的是排列数
        for (int i = 0; i <= target ; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]){
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}
