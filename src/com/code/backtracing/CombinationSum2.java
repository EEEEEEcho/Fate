package com.code.backtracing;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates,target,ans,new ArrayDeque<>(),0,candidates.length);
        return ans;
    }
    public void dfs(int[] candidates, int target, List<List<Integer>> ans, Deque<Integer> path,int start,int len){
        if (target == 0){
            ans.add(new ArrayList<>(path));
        }
        else if(start >= len){
            return;
        }
        else{
            for (int i = start;i < len;i ++){
                if (i > start && candidates[i] == candidates[i - 1]) continue;
                if(target - candidates[i] < 0){
                    break;
                }
                path.add(candidates[i]);
                dfs(candidates,target - candidates[i],ans,path,i + 1,len);
                path.removeLast();
            }
        }
    }
}
