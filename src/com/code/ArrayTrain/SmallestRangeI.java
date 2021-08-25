package com.code.ArrayTrain;

import java.util.Arrays;

public class SmallestRangeI {
    public int smallestRangeI(int[] nums, int k) {
        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();
        max -= k;
        min += k;
        if (max - min < 0){
            return 0;
        }
        else{
            return max - min;
        }
    }
}
