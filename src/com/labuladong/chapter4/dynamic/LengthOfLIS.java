package com.labuladong.chapter4.dynamic;

import java.util.Arrays;

public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        //dp[i] 表示以 nums[i] 这个数结尾的最⻓递增⼦序列的⻓度
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[j] + 1,dp[i]);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
