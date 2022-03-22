package com.code.backtracing;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 全排列系列需要有一个mark数组来记录是否被选择过，
 * 子集系列只需一直向前执行，判断当前元素要不要
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums,0,ans,path);
        return ans;
    }

    public void dfs(int[] nums,int index,List<List<Integer>> ans,Deque<Integer> path){
        //每一次递归，都是一个子集
        ans.add(new ArrayList<>(path));
        for (int i = index;i < nums.length;i ++){
            path.add(nums[i]);  //加上当前元素向下继续寻找子集
            dfs(nums,i + 1,ans,path);
            path.removeLast();  //不加当前元素，继续寻找
        }
    }
}
