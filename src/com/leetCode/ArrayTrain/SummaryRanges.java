package com.leetCode.ArrayTrain;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        for (int i = 0,j = 0; i < nums.length; i++) {
            if (i + 1 < nums.length && nums[i + 1] == nums[i] + 1){
                continue;
            }
            if (i == j){
                result.add(nums[i]  + "");
            }
            else {
                result.add(nums[j] + "->" + nums[i]);
            }
            j = i + 1;
        }
        return result;
    }
}
