package com.labuladong.chapter4.dynamic;

import java.util.Arrays;

public class LongestCommonSubsequence {
    private int[][] memo;
    public int longestCommonSubsequence1(String text1, String text2) {
        memo = new int[text1.length()][text2.length()];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i],-1);
        }
        return dp(text1,0,text2,0);
    }
    //自顶向下
    public int dp(String s1,int i,String s2,int j){
        if (i == s1.length() || j == s2.length()){
            return 0;
        }
        if (memo[i][j] != -1){
            //计算过。
            return memo[i][j];
        }
        if (s1.charAt(i) == s2.charAt(j)){
            return 1 + dp(s1,i + 1,s2,j + 1);
        }
        else{
            memo[i][j] = Math.max(
                    dp(s1,i + 1,s2,j),
                    dp(s1,i,s2,j + 1)
            );
        }
        return memo[i][j];
    }

    //自底向上
    public int longestCommonSubsequence2(String text1, String text2) {
        //dp数组的含义是：dp[i][j]代表text1[0..i-1]，text2[0..j-1]字符串的最长公共子序列
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length() - 1][text2.length() - 1];
    }
}
