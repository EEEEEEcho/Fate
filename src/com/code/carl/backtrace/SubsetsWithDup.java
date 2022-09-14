package com.code.carl.backtrace;

import java.util.*;
import java.util.stream.Collectors;

public class SubsetsWithDup {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backTrace(nums,new ArrayDeque<>(),0,used);
        return result;
    }

    public void backTrace(int[] nums, Deque<Integer> path,int start,boolean[] used){
        List<Integer> integers = new ArrayList<>(path);
        result.add(integers);
        for (int i = start; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]){
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            backTrace(nums,path,i + 1,used);
            used[i] = false;
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4));
        String collect = list.stream().map(String::valueOf).collect(Collectors.joining(","));
        System.out.println(collect);
    }
}

