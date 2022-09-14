package com.interview.cs;

public class Main3 {
    public int longestValidParentheses (String s) {
        // write code here
        if (s.length() <= 1) return 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                dp[i] = dp[i - 1];
            }
            else {
                if (s.charAt(i - 1) == '('){
                    dp[i] = dp[i - 1] + 2;
                }
                else{
                    dp[i] = dp[i - 1];
                }
            }
        }
        return dp[s.length() - 1];
    }
}
