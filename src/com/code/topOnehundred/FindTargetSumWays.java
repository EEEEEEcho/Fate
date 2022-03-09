package com.code.topOnehundred;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class FindTargetSumWays {
    private int count = 0;
    public int findTargetSumWays(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        backTrace(nums,target,0,0);
        return count;
    }
    //回溯可行，时间复杂度高，这是全局变量维护的情况
    public void backTrace(int[] nums,int target,int i,int sum){
        if(i == nums.length){
            if(target == sum){
                count ++;
            }
        }
        else{
            backTrace(nums,target,i + 1,sum - nums[i]);
            backTrace(nums,target,i + 1,sum + nums[i]);
        }
    }
    //带有返回值的回溯
    public int backTrace2(int[] nums,int target,int i,int sum){
        if (i == nums.length){
            //如果遍历到了nums的末尾，且target = sum就证明找到了一个，就要返回1
            return target == sum ? 1 : 0;
        }
        else{
            //向左找，看看有没有符合条件的
            int left = backTrace2(nums,target,i + 1,sum + nums[i]);
            //向右找看看有没有符合条件的
            int right = backTrace2(nums,target,i + 1,sum - nums[i]);
            return left + right;
        }
    }
    //记忆化搜索
    //因为只有两个状态，一个是下标i一个是当前和sum，可以使用i_sum为键，以当前是否找到为值进行记忆化搜索
    HashMap<String,Integer> memo = new HashMap<>();
    public int backTrace3(int[] nums,int target,int i,int sum){
        String key = i + "_" + sum;
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        if (i == nums.length){
            //如果遍历到了nums的末尾，且target = sum就证明找到了一个，就要返回1
            memo.put(key,sum == target ? 1 : 0);
            return memo.get(key);
        }
        //向左找，看看有没有符合条件的
        int left = backTrace3(nums,target,i + 1,sum + nums[i]);
        //向右找看看有没有符合条件的
        int right = backTrace3(nums,target,i + 1,sum - nums[i]);
        memo.put(key,left + right);
        return memo.get(key);
        
    }



    //动态规划
    public int findTargetSumWays2(int[] nums, int target) {
        //dp[i][j] 就是以前0..i个数，以题目要求方式凑出j的方案数量
        //dp[i][j] = dp[i-1][j - nums[i - 1]] + dp[i-1][j + nums[i - 1]]
        //这里可能会出现j - nums[i - j] < 0的情况，所以需要进行范围扩大
        int s = 0;
        for (int num : nums){
            s += Math.abs(num);
        }
        if (Math.abs(target) > s) return 0;
        //扩容，防止出现全是-1的情况
        int[][] dp = new int[nums.length + 1][2 * s + 1];
        //用0个数凑出0的方案是1
        dp[0][0] = 1;
        for (int i = 1; i <= nums.length ; i++) {
            int x = nums[i - 1];
            for (int j = 1; j <= s; j++) {
                dp[i][j + s] = dp[i - 1][j + s - x] + dp[i - 1][j + s + x];
            }
        }
        return dp[nums.length][target];
    }
}
