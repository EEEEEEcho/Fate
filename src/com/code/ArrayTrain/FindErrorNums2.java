package com.code.ArrayTrain;

import java.util.*;

public class FindErrorNums2 {
    public int[] findErrorNums(int[] nums) {
        int[] errors = new int[2];
        Map<Integer,Integer> hashMap = new HashMap<>();
        for(int num : nums){
            //hashMap.getOrDefault如果有num，则返回num对应的值，否则返回指定的默认值0
            hashMap.put(num, hashMap.getOrDefault(num,0) + 1);
        }
        for (int i = 1; i <= nums.length; i++) {
            int count = hashMap.getOrDefault(i,0);
            if (count == 2){
                errors[0] = i;
            }
            else if(count == 0){
                errors[1] = i;
            }
        }
        return errors;
    }

    public int[] findErrorNums2(int[] nums) {
        /**
         * 第一个元素：重复元素 = 当前数组和 - 去重后的数组和
         * 第二个元素：缺失元素 = 数学1~n求和 - 去重后的数组和
         */
        int result[] = new int[2];
        result[0] = Arrays.stream(nums).sum() - Arrays.stream(nums).distinct().sum();
        result[1] = (1 + nums.length) * nums.length / 2 - Arrays.stream(nums).distinct().sum();
        return result;
    }
}
