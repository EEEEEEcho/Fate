package com.code.carl.backtrace;

import java.util.*;

public class FindSubsequences {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        Arrays.sort(nums);
        backTrace(nums,new ArrayDeque<>(),0);
        return list;
    }

    public void backTrace(int[] nums, Deque<Integer> path,int start){
        if (path.size() > 1){
            list.add(new ArrayList<>(path));
        }
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if ((!path.isEmpty() && path.getLast() > nums[i]) ||
                    hashSet.contains(nums[i])){
                continue;
            }
            path.addLast(nums[i]);
            hashSet.add(nums[i]);
            backTrace(nums,path,i + 1);
            path.removeLast();
        }
    }
}
