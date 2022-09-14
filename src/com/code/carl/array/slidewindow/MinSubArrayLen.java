package com.code.carl.array.slidewindow;

public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0 ||(nums.length == 1 && nums[0] != target)) return 0;
        int left = 0;
        int right = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        while (right < nums.length){
            sum += nums[right];
            right ++;
            while (sum >= target){
                res = Math.min(res,right - left);
                sum -= nums[left ++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        MinSubArrayLen arrayLen = new MinSubArrayLen();
        int i = arrayLen.minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1});
        System.out.println(i);
    }
}
