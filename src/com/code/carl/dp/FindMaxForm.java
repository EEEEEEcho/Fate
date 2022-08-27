package com.code.carl.dp;

public class FindMaxForm {
    public int findMaxForm(String[] strs, int m, int n) {
        //dp[i][j]表示最多有i个0和j个1的strs的最大子集大小为dp[i][j]
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs){
            int zero = 0;
            int one = 0;
            for(char c : str.toCharArray()){
                if (c == '0'){
                    zero ++;
                }
                else{
                    one ++;
                }
            }
            for (int i = m;i >= zero;i --){
                for (int j = n; j >= one ; j--) {
                    dp[i][j] = Math.max(dp[i][j],dp[i - zero][j - one] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
