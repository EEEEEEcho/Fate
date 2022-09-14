package com.code.codertop;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        //dp[i][j]代表text1[0..i]和text2[0..j]的最长公共子序列
        int[][] dp = new int[m + 1][n + 1];
        //2.递推公式
        //如果当前位置的两个字符相同那么dp[i][j] = dp[i-1][j-1] + 1
        //否则 dp[i][j] = max(dp[i - 1][j],dp[i][j -1])
        //3.初始条件 s1为空，s2不为空，公共序列长度为0，s2为空，s1不为空同理
        for (int i = 0;i < m + 1;i ++){
            dp[i][0] = 0;
        }
        for (int j = 0; j < n + 1; j++) {
            dp[0][j] = 0;
        }
        //4.推导顺序，从前向后
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
