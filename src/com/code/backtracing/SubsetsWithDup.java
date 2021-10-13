package com.code.backtracing;

import java.util.*;

public class SubsetsWithDup {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        Arrays.sort(nums);
        dfs(nums,0,ans,path);
        return ans;
    }

    public void dfs(int[] nums,int index,List<List<Integer>> ans,Deque<Integer> path){
        //每一次递归，都是一个子集
        ans.add(new ArrayList<>(path));
        for (int i = index;i < nums.length;i ++){
            //剪枝思路和全排列的剪枝一样
            if (i > index && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);  //加上当前元素向下继续寻找子集
            dfs(nums,i + 1,ans,path);
            path.removeLast();  //不加当前元素，继续寻找
        }
    }

}
