package com.code.BitMultiplication;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> hashMap = new HashMap<>();
        for(int integer : nums){
            if(hashMap.get(integer) == null){
                hashMap.put(integer,1);
            }
            else{
                hashMap.put(integer,hashMap.get(integer) + 1);
            }
        }
        for(Map.Entry<Integer,Integer> entry : hashMap.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return 0;
    }
}
