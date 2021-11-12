package com.code.Dynamic;

public class CanJump {
    public boolean canJump(int[] nums) {
        if(nums.length == 1){
            return true;
        }
        else{
            boolean[] dp = new boolean[nums.length];
            dp[0] = true;
            dp[1] = dp[0] && nums[0] >= 1;
            for (int i = 2; i < nums.length; i++) {
                dp[i] = dp[i - 1] && nums[i - 1] >= 1;
            }
            return dp[dp.length - 1];
        }
    }
}
