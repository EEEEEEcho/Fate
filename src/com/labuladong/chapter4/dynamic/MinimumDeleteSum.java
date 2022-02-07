package com.labuladong.chapter4.dynamic;

import java.util.Arrays;

public class MinimumDeleteSum {
    //1.备忘录
    int[][] memo;
    public int minimumDeleteSum(String s1, String s2) {
        //初始化备忘录
        memo = new int[s1.length()][s2.length()];
        for (int i = 0; i < s1.length(); i++) {
            Arrays.fill(memo[i],-1);
        }
        return dp(s1,0,s2,0);
    }
    //定义状态转移函数
    public int dp(String s1,int i,String s2,int j){
        int res = 0;
        if (i == s1.length()){
            for (;j < s2.length();j ++){
                res += s2.charAt(j);
            }
            return res;
        }
        if (j == s2.length()){
            for(;i < s1.length();i ++){
                res += s1.charAt(i);
            }
            return res;
        }
        if (memo[i][j] != -1){
            return memo[i][j];
        }
        if (s1.charAt(i) == s2.charAt(j)){
            memo[i][j] = dp(s1,i + 1,s2,j + 1);
        }
        else{
            memo[i][j] = Math.min(s1.charAt(i) + dp(s1,i + 1,s2,j),s2.charAt(j) + dp(s1,i,s2,j + 1));
        }
        return memo[i][j];
    }
}
