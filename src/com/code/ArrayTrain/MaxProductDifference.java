package com.code.ArrayTrain;

import java.util.Arrays;

public class MaxProductDifference {
    public int maxProductDifference(int[] nums) {
        int max = 0;
        int anotherMax = 0;
        int min = Integer.MAX_VALUE;
        int anotherMin = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max){
                anotherMax = max;
                max = nums[i];
            }
            else if(nums[i] > anotherMax && nums[i] < max){
                anotherMax = nums[i];
            }

            if (nums[i] < min){
                anotherMin = min;
                min = nums[i];
            }
            else if(nums[i] < anotherMin && nums[i] > min){
                anotherMin = nums[i];
            }
        }
        return max * anotherMax - min* anotherMin;
    }
}
