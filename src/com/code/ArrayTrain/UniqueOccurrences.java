package com.code.ArrayTrain;

import java.util.*;

public class UniqueOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        //空间换时间
        for (int num : arr){
            map.merge(num, 1, Integer::sum);
        }
        Set<Integer> set = new HashSet<>(map.values());
        if (set.size() == map.size()){
            return true;
        }
        return false;
    }
}
