package com.code.Dynamic;

public class Rob {
    public int rob(int[] nums) {
        //2112
        int n = nums.length;
        if (n == 1){
            return nums[0];
        }
        else if(n == 2){
            return Math.max(nums[0],nums[1]);
        }
        else{
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < n; i++) {
                dp[i] = Math.max(dp[i - 1],dp[i - 2] + nums[i]);
            }
            return dp[dp.length - 1];
        }
    }

    //优化空间后
    public int rob2(int[] nums){
        int n = nums.length;
        if (n == 1){
            return nums[0];
        }
        else if(n == 2){
            return Math.max(nums[0],nums[1]);
        }
        else{
            int first = nums[0];
            int second = Math.max(nums[0],nums[1]);
            for (int i = 2; i < nums.length; i++) {
                int tmp = second;
                second = Math.max(first + nums[i],second);
                first = tmp;
            }
            return second;
        }
    }
}
