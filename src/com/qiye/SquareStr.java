package com.qiye;

import java.util.Scanner;

public class SquareStr {
    /**
     * 题目的意思就是把一个字符串拆成两个连续的子串，然后找出两个拆分串的最大公共子序列的长度，
     * 可以枚举给定字符串的拆分点，dp[i][j]表示的意思是两个拆分后的字符串0-i和0-j子串的最长公共子序列,
     * 用到dp的思想
     * @param
     */
    public static int LSC(String s1,String s2){
        int dp[][] = new int[55][55];
        for(int i = 1;i <= s1.length();i ++){
            for(int j=1;j <= s2.length();j ++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int maxn = 0;
        for(int i=1;i < s.length();i ++){
            int num = LSC(s.substring(0,i),s.substring(i));
            maxn = Math.max(maxn,num);
        }
        System.out.println(maxn * 2);
    }
}
