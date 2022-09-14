package com.code.carl.hashtable;

import java.util.HashMap;
import java.util.Map;

public class FourSumCount {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        //只要找出nums1、nums2、nums3、nums4中存在相加和为0的元素就行
        //先在1、2中找
        Map<Integer,Integer> map = new HashMap<>();
        for(int num1 : nums1){
            for (int num2 : nums2){
                map.put(num1 + num2,map.getOrDefault(num1 + num2,0) + 1);
            }
        }
        int count = 0;
        for (int num3 : nums3){
            for (int num4 : nums4){
                if (map.containsKey(- (num3 + num4))){
                    count += map.get(- (num3 + num4));
                }
            }
        }
        return count;
    }
}
