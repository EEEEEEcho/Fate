package com.code.backtracing;

import java.util.*;

public class CombinationSum {
    /**
     * 朴素回溯，无剪枝
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
         List<List<Integer>> ans = new ArrayList<>();
         dfs1(ans,0, candidates.length,candidates, target,new ArrayDeque<Integer>());
         return ans;
    }
    public void dfs1(List<List<Integer>> ans, int begin, int len, int[] candidates, int target, Deque<Integer> path){
        if (target == 0){
            ans.add(new ArrayList<>(path));
        }
        if (target < 0){
            return;
        }
        else{
            for (int i = begin; i < len; i++) {
                path.add(candidates[i]);
                dfs1(ans,i,len,candidates,target - candidates[i],path);
                path.removeLast();
            }
        }
    }

    /**
     * 剪枝，剪枝的思想就是，如果target减掉一个数已经小于0了，那么同理减掉比那个数大的数，就都小于0，就要剪枝
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target){
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        dfs2(ans,0,candidates.length,candidates,target,new ArrayDeque<>());
        return ans;
    }
    public void dfs2(List<List<Integer>> ans,int begin,int len,int[] candidates, int target,Deque<Integer> path){
        if (target == 0){
            ans.add(new ArrayList<>(path));
            return;
        }
        else{
            for (int i = begin; i < len; i++) {
                if(target - candidates[i] < 0){
                    break;
                }
                path.add(candidates[i]);
                //每一次递归调用都有一个自己的方法栈，其中的局部变量不会影响其他方法栈中的
                dfs2(ans,i,len,candidates,target - candidates[i],path);
                path.removeLast();
            }
        }
    }
}
