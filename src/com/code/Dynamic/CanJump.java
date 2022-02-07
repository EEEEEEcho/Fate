package com.code.Dynamic;

public class CanJump {

    /**
     * 贪心，一个一个跳，更新最大距离
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max < i) return false;
            max = Math.max(nums[i] + i, max);
        }
        return true;
    }

    public boolean canJump2(int[] nums) {
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
