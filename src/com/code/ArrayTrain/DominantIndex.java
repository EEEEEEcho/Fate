package com.code.ArrayTrain;

import java.util.Arrays;
import java.util.OptionalInt;

public class DominantIndex {
    public int dominantIndex(int[] nums) {
        int max = -1;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max){
                max = nums[i];
                index = i;
            }
        }
        for (int num : nums){
            if (max != num && max < num * 2){
                return -1;
            }
        }
        return index;
    }
}
