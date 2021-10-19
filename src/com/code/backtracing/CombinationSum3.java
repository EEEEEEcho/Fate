package com.code.backtracing;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CombinationSum3 {
    List<List<Integer>> ans = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(1,n,k);
        return ans;
    }

    public void dfs(int start,int target,int k){
        if(k == 0){
            if (target == 0){   //其实在这里也算剪了？
                ans.add(new ArrayList<>(path));
            }
        }
        else{
            for (int i = start; i <= 9 ; i++) {
                if (target - i < 0) return; //剪枝
                path.add(i);
                dfs(i + 1,target - i,k - 1);
                path.removeLast();
            }
        }
    }
}
