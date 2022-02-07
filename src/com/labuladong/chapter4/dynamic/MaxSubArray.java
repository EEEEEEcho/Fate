package com.labuladong.chapter4.dynamic;

import java.util.Arrays;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        //dp数组的定义：dp[i]是以i结尾的最大字序和，而不是[0..i]数组的最大子序和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i],nums[i]);
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
