package com.code.Dynamic;

public class RobTwo {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n  == 1){
            return nums[0];
        }
        else if(n == 2){
            return Math.max(nums[0],nums[1]);
        }
        else {
            int first = nums[0];
            int second = Math.max(nums[0],nums[1]);
            nums[0] = -1;
            nums[1] = -1;
            int i = 2;
            while (nums[i % n] > 0){
                int tmp = second;
                if(i != n - 1  && first + nums[i % n] > second){
                    second = first + nums[i % n];
                    nums[i % n] = -1;
                }
                first = tmp;
                i ++;
            }
            return second;
        }
    }
}
