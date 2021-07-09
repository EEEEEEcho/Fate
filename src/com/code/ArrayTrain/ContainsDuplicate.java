package com.code.ArrayTrain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]){
                return true;
            }
        }
        return false;
    }
    public boolean containsDuplicate2(int[] nums){
        Set<Integer> set = new HashSet<>();
        for (Integer integer : nums){
            if(!set.add(integer)){
                return true;
            }
        }
        return false;
    }
}
