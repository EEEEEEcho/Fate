package com.labuladong.chapter3.backtrace;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Subsets {
    private List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrace(nums,new ArrayDeque<>(),0);
        return list;
    }
    public void backtrace(int[] nums, ArrayDeque<Integer> path,int index){
        //没有base条件,每一次递归都是一个子集
        list.add(new ArrayList<>(path));
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            backtrace(nums,path,i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        subsets.subsets(new int[]{1,2,3});
    }
}
