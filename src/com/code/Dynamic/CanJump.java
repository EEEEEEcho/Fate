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
}
