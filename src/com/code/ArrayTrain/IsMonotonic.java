package com.code.ArrayTrain;

public class IsMonotonic {
    public boolean isMonotonic(int[] nums) {
        if(nums.length == 1){
            return true;
        }
        boolean up = true;
        boolean down = true;
        for(int i = 0;i < nums.length - 1;i ++){
            if(nums[i + 1] - nums[i] < 0){
                up = false;
                break;
            }
        }
        for (int i = 0;i < nums.length - 1;i ++){
            if (nums[i] - nums[i + 1] < 0){
                down = false;
                break;
            }
        }
        return up || down;
    }
}
