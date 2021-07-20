package com.code.ArrayTrain;

import java.util.Arrays;

public class FindErrorNums {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int[] result = new int[2];
        for (int i = 1; i <= nums.length; i++) {
            if ((i ^ nums[i - 1]) != 0){
                result[0] = i;
                result[1] = nums[i - 1];
                break;
            }
        }
        return result;
    }
}
