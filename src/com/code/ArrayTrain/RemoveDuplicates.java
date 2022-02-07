package com.code.ArrayTrain;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int p = 0;
        int q = p + 1;
        while (q < nums.length){
            if (nums[p] == nums[q]){
                q ++;
            }
            else {
                p ++;
                nums[p] = nums[q];
            }
        }
        return p;
    }
}
