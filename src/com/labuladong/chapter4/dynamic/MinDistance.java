package com.labuladong.chapter4.dynamic;

public class MinDistance {
    public int minDistance(String word1, String word2){
        //1.定义dp数组，dp数组中的dp[i][j]，代表以word1[0..i - 1]和word2[0..j-1]的最大公共字串
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
                }
            }
        }
        return word1.length() + word2.length() - 2 * dp[m][n];
    }
}
