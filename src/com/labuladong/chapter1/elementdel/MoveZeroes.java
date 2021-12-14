package com.labuladong.chapter1.elementdel;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int fast = 0;
        int slow = 0;
        while (fast < nums.length){
            if(nums[fast] != 0){
                nums[slow] = nums[fast];
                slow ++;
            }
            fast ++;
        }
        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
