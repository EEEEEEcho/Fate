package com.labuladong.chapter3.backtrace;

import java.util.*;

/**
 * 46.全排列
 */
public class Permute {
    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        dfs(nums,0,new ArrayDeque<>(),new boolean[nums.length]);
        return ans;
    }
    public void dfs(int[] nums, int n, Deque<Integer> deque,boolean[] marked){
        if(deque.size() == nums.length){
            ans.add(new ArrayList<>(deque));
            marked[n] = false;
            return;
        }
        else{
            for (int i = 0; i < nums.length; i++) {
                if (!marked[i]){
                    marked[i] = true;
                    deque.add(nums[i]);
                    dfs(nums,i,deque,marked);
                    deque.removeLast();
                    marked[i] = false;
                }
            }
        }
    }

    public List<List<Integer>> permute2(int[] nums) {
        backtrace(nums,new LinkedList<>());
        return ans;
    }

    public void backtrace(int[] nums, LinkedList<Integer> path){
        // 终止条件
        if (path.size() == nums.length){
            ans.add(new ArrayList<>(path));
        }
        else{
            for (int i = 0; i < nums.length; i++) {
                //排除不正确的选择
                if (path.contains(nums[i])){
                    continue;
                }
                //做选择。
                path.add(nums[i]);
                //回溯
                backtrace(nums,path);
                //取消选择
                path.removeLast();
            }
        }
    }
}
