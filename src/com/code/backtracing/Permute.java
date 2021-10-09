package com.code.backtracing;

import java.util.*;

public class Permute {
    /**
     * 我自己写的，竟然过了！！！
     * @param nums
     * @return
     */
    public List<List<Integer>> permute1(int[] nums) {
        int[] mark = new int[nums.length];
        List<List<Integer>> ans = new ArrayList<>();
        dfs1(nums,mark,new ArrayDeque<>(),0,ans);
        return ans;
    }


    public void dfs1(int[] nums, int[] mark,Deque<Integer> deque,int markIndex,List<List<Integer>> ans){
        if (deque.size() == nums.length){
            ans.add(new ArrayList<>(deque));
            mark[markIndex] = 0;
        }
        else{
            for (int i = 0; i < nums.length; i++) {
                if (mark[i] == 0){
                    deque.add(nums[i]);
                    mark[i] = 1;
                    dfs1(nums,mark,deque,i,ans);
                    mark[i] = 0;
                    deque.removeLast();
                }
            }
        }
    }
}
