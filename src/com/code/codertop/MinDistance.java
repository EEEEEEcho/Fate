package com.code.codertop;

import java.util.Arrays;

public class MinDistance {
    //最基本的框架
//    public int minDistance(String word1, String word2) {
//        int m = word1.length();
//        int n = word2.length();
//        //自顶向下，从字符串最后一个字符开始向前，寻找最小的编辑距离
//        return dp(word1,m - 1,word2,n - 1);
//    }
//    //dp(word1,i,word2,j)代表从word1[0..i] 和 word2[0..j]的最小编辑距离
//    public int dp(String word1,int i,String word2,int j){
//        if (i == -1) return j + 1;
//        if (j == -1) return i + 1;
//        if (word1.charAt(i) == word2.charAt(j)){
//            //如果当前位置两个字符相同，那么就向前移动指针
//            return dp(word1,i - 1,word2,j - 1);
//        }
//        else {
//            return Math.min(
//                    Math.min(dp(word1,i,word2,j - 1) + 1, //在word1的i后边添加一个和word2[j]相同的字符，j前进一个
//                        dp(word1,i - 1,word2,j) + 1     // 删除word1当前位置的字符，然后i前进一个，j不用动
//                    ),
//                    dp(word1,i - 1,word2,j - 1) + 1 //修改word1或者word2当前位置的字符，使二者相等，然后两个都往前走
//            );
//        }
//    }

    //添加备忘录
    int memo[][];
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        memo = new int[m + 1][n + 1];
        for (int i = 0; i < memo.length;i ++){
            Arrays.fill(memo[i],-1);
        }
        dp(word1,m - 1,word2,n - 1);
        return memo[1][1];
    }

    public int dp(String word1,int i,String word2,int j){
        if (i == -1) return j + 1;
        if (j == -1) return i + 1;
        // 先查备忘录，避免重叠子问题
        if (memo[i][j] != -1) return memo[i][j];

        if (word1.charAt(i) == word2.charAt(j)){
//            本来就相等，不需要任何操作,s1[0..i] 和 s2[0..j] 的最小编辑距离等于s1[0..i-1] 和 s2[0..j-1] 的最小编辑距离
//            也就是说 dp(i, j) 等于 dp(i-1, j-1)
            memo[i][j] = dp(word1,i - 1,word2,j - 1);
        }
        else{
            memo[i][j] = min(
                    //插入：直接在s1[i] 插入一个和s2[j]一样的字符，那么s2[j]就被匹配了，前移j，继续跟i对比
                    dp(word1,i,word2,j - 1) + 1,
                    //删除: 直接把 s[i] 这个字符删掉前移 i，继续跟 j 对比
                    dp(word1,i - 1,word2,j) + 1,
                    //修改 ：直接把 s1[i] 替换成 s2[j]，这样它俩就匹配了，同时前移 i，j 继续对比
                    dp(word1,i - 1,word2,j - 1) + 1
            );
        }
        return memo[i][j];
    }
    private int min(int x,int y,int z){
        return Math.min(x,Math.min(y,z));
    }


    public int minDistance1(String word1, String word2) {
        //自顶向下
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;   //word1为i，word2长度为0时，将word1变为word2需要的操作数为i(删除i次)
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i; //word1为0，word2长度为i时，将word1变为word2需要的操作数为i次（添加i次）
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i) == word2.charAt(j)){
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else{
                    dp[i][j] = min(
                            dp[i - 1][j] + 1, //删除
                            dp[i][j - 1] + 1,//插入
                            dp[i - 1][j - 1] + 1//修改
                    );
                }
            }
        }
        return dp[m][n];
    }
}
