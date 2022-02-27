package com.code.topOnehundred;

public class CountSubstrings {
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int ans = 0;
        //dp[i][j]表示
        for (int j = 0; j < dp.length; j++) {
            for (int i = 0; i <=j ; i++) {
                if (s.charAt(i) == s.charAt(j) && ((j - i < 2) || dp[i + 1][j - 1])){
                    dp[i][j] = true;
                    ans++;
                }

            }
        }
        return ans;
    }
    //中心扩散法
    public int countSubstrings1(String s){
        int ans = 0;
        for (int center = 0; center < 2 * s.length() - 1; center++) {
            int left = center / 2;
            int right = left + center % 2;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                ans ++;
                left --;
                right ++;
            }
        }
        return ans;
    }
}
