package com.code.carl.dp;

public class Rob2 {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int res1 = doRob(nums,0,nums.length - 2);
        int res2 = doRob(nums,1,nums.length - 1);
        return Math.max(res1,res2);
    }
    public int doRob(int[] nums,int start,int end){
        if(start == end) return nums[start];
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start],nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 1],dp[i - 2] + nums[i]);
        }
        return dp[end];
    }
}
