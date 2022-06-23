package com.code.EveryDay;

import java.util.Map;

public class MinFlipsMonoIncr {
    //不通过
//    public int minFlipsMonoIncr(String s) {
//        if (s == null || s.length() == 0) {
//            return 0;
//        }
//        int n = s.length();
//        int[][] dp = new int[n][2];
//        /**
//         * 单调递增的字符串满足以下性质：
//         * 首个字符是 00 或 11；
//         * 其余的每个字符，字符 00 前面的相邻字符一定是 00，字符 11 前面的相邻字符可以是 00 或 11。
//         */
//        dp[0][0] = s.charAt(0) == '1' ? 1 : 0;
//        dp[0][1] = s.charAt(0) == '0' ? 1 : 0;
//        //dp[i][0] 和 dp[i][1] 分别表示下标i处的字符为0和1的情况下使得s[0..i]单调递增的最小翻转次数
//        for (int i = 1; i < n; i++) {
//            dp[i][0] = dp[i - 1][0] + s.charAt(i) == '1' ? 1 : 0;
//            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + s.charAt(i) == '0' ? 1 : 0;
//        }
//        return Math.min(dp[n - 1][0], dp[n - 1][1]);
//    }
    public int minFlipsMonoIncr(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int n = s.length();
        int dp = 0;
        int oneCnt = 0;
        //  1 不影响最终结果
        //  0 遇到0有两种方案，将当前位置的0反转成1或者将当前位置之前的1全部变成0
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '1'){
                oneCnt ++;
            }
            else {
                dp = Math.min(dp + 1,oneCnt);
            }
        }
        return dp;
    }
}
