package com.leetCode.ArrayTrain;

import java.util.HashMap;
import java.util.Map;

public class ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0;i < nums.length;i ++){
            if (hashMap.containsKey(nums[i]) && Math.abs(hashMap.get(nums[i]) - i)<= k){
                return true;
            }
            hashMap.put(nums[i],i);
        }
        return false;
    }
}
