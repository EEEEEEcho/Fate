package com.code.carl.backtrace;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTrace(new ArrayDeque<>(),candidates,target,0);
        return ans;
    }

    public void backTrace(Deque<Integer> path,int[] candidates,int target,int start){
        if (target == 0){
            ans.add(new ArrayList<>(path));
        }
        else if (target > 0){
            for (int i = start; i < candidates.length; i++) {
                target -= candidates[i];
                path.addLast(candidates[i]);
                backTrace(path,candidates,target,i);
                path.removeLast();
                target += candidates[i];
            }
        }
    }
}
