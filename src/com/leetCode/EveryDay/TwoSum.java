package com.leetCode.EveryDay;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

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

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
}
