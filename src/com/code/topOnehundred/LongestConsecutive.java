package com.code.topOnehundred;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums){
            hashSet.add(num);
        }
        int longest = 0;
        for(int num : hashSet){
            if (!hashSet.contains(num - 1)){
                int currentNum = num;
                int current = 1;
                while (hashSet.contains(currentNum + 1)){
                    currentNum += 1;
                    current ++;
                }
                longest = Math.max(longest,current);
            }
        }
        return longest;
    }
}
