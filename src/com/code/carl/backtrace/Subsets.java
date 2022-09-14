package com.code.carl.backtrace;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Subsets {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backTrace(nums,new ArrayDeque<>(),0);
        return result;
    }
    public void backTrace(int[] nums, Deque<Integer> path,int start){
        result.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.addLast(nums[i]);
            backTrace(nums,path,i + 1);
            path.removeLast();
        }
    }
}
