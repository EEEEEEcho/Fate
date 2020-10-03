package com.leetCode.EveryDay;

import java.util.HashMap;
import java.util.HashSet;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i = 0;i < nums.length;i ++){
            if(hashMap.get(nums[i]) != null){
                return new int[]{i, hashMap.get(nums[i])};
            }
            hashMap.put(target - nums[i],i);
        }
        return null;
    }
}
