package com.code.ArrayTrain;

import java.util.Arrays;

public class PivotIndex {
    public int pivotIndex(int[] nums) {
        double sum = Arrays.stream(nums).sum();
        if (sum == 0){
            return 0;
        }
        double subSum = 0;
        for (int i = 0; i < nums.length; i++) {
            System.out.println("left:" + (sum - nums[i] - subSum) + " right:" + ((sum - nums[i]) / 2));
            if (sum  - nums[i] - subSum == (sum - nums[i]) / 2){
                return i + 1;
            }
            subSum += nums[i];
        }
        return -1;
    }
}
