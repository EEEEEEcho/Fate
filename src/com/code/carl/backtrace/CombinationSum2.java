package com.code.carl.backtrace;

import java.util.*;

public class CombinationSum2 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        boolean[] used = new boolean[candidates.length];
        backTrace(new ArrayDeque<>(),candidates,used,0,target);
        return result;
    }

    public void backTrace(Deque<Integer> path,int[] candidates,boolean[] used,int start,int target){
        if (target == 0){
            result.add(new ArrayList<>(path));
        }
        else if (target > 0){
            for (int i = start; i < candidates.length; i++) {
                //因为排序过了。所以可以这样判断，如果前面的一个元素没用过,在它之后又选择了和它相同的值，就会出现重复
                if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]){
                    continue;
                }
                target -= candidates[i];
                used[i] = true;
                path.addLast(candidates[i]);
                backTrace(path,candidates,used,i + 1,target);
                path.removeLast();
                used[i] = false;
                target += candidates[i];
            }
        }
    }
}
