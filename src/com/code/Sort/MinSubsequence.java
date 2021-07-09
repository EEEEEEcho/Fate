package com.code.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinSubsequence {
    /**
     * 未解决，有点难
     * @param nums
     * @return
     */
    public List<Integer> minSubsequence(int[] nums) {
        int sum = 0;
        for(int i=0;i < nums.length;i ++){
            sum += nums[i];
        }
        Arrays.sort(nums);
        int subSum = 0;
        int index = 0;
        for(int i = nums.length - 1;i >=0;i --){
            subSum += nums[i];
            if(subSum > (sum - subSum)){
                index = i;
                break;
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i = nums.length - 1;i >= index; i--){
            result.add(nums[i]);
        }
        return result;
    }
}
