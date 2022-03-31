package com.code.carl.array.slidewindow;

public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        if(nums == null || (nums.length == 1 && target != nums[0])) return 0;
        int left = 0;
        int right = 0;
        int sum = 0;
        int count = Integer.MAX_VALUE;
        while (right < nums.length){
            sum += nums[right];
            right ++;
            while (sum - target >= 0){
                count = Math.min(count,right - left);
                sum -= nums[left];
                left ++;
            }
        }
        return count == Integer.MAX_VALUE ? 0 : count;
    }

    public static void main(String[] args) {
        MinSubArrayLen arrayLen = new MinSubArrayLen();
        int i = arrayLen.minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1});
        System.out.println(i);
    }
}
