package com.code.ArrayTrain;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            if (hashMap.containsKey(target - numbers[i])){
                result[0] = hashMap.get(target - numbers[i]) + 1;
                result[1] = i + 1;
                break;
            }
            hashMap.put(numbers[i],i);
        }
        return result;
    }
}
