package com.labuladong.chapter4.dynamic;

import java.util.Arrays;

public class EditDistance {


//    //自顶向下比较好理解,倒着遍历
//    private int[][] memo;
//    public int minDistance(String word1, String word2) {
//        int m = word1.length() + 1;
//        int n = word2.length() + 1;
//        memo = new int[m][n];
//        for(int[] row: memo){
//            Arrays.fill(row,-1);
//        }
//        dp(word1, word1.length() - 1,word2, word2.length() - 1);
//        return memo[m][n];
//    }
//
//    private int dp(String word1,int i,String word2,int j){
//        if (i == -1) return 0;
//        if (j == -1) return 0;
//        if (memo[i][j] != -1){
//            return memo[i][j];
//        }
//        if (word1.charAt(i) == word2.charAt(j)){
//            //从后往前走。如果两个字符都相等，那么继续向前走
//            memo[i][j] = dp(word1,i - 1,word2,j - 1);
//        }
//        else{
//            memo[i][j] = min(
//                    dp(word1,i,word2,j - 1) + 1,    //增加一个，增加这个字符在位置i
//                    dp(word1,i - 1,word2,j) + 1,    //删除一个，删除的字符在位置i
//                    dp(word1,i - 1,word2,j - 1) + 1 //替换.替换的字符在位置i和位置j
//            );
//        }
//        return memo[i][j];
//    }


    //自底向上不太好理解
    public int minDistance1(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        //dp[i][j]的含义表示word1[0..i]到word[0..j]的最小编辑距离
        int[][] dp = new int[m + 1][n + 1];
        //base case：word2是一个空串，那么从word1的第i个字符变成一个空串，所需要的操作为i,删除i次
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = i;
        }
        //word1是一个空串，那么从word1变为word2的第j个字符所需要的操作为j次,即添加j次
        for (int j = 0; j < n + 1; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)){
                    //如果两个位置的字符相等，那么不需要操作
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else{
                    //两个位置的字符不相等
                    dp[i][j] = min(
                            dp[i][j - 1] + 1,       //插入
                            dp[i - 1][j] + 1,       //删除
                            dp[i - 1][j - 1] + 1   //替换
                    );
                }
            }
        }
        return dp[m][n];
    }

    private int min(int a,int b,int c){
        return Math.min(a,Math.min(b,c));
    }
}
