package com.code.EveryDay;

import java.util.HashMap;
import java.util.Map;

public class OneEditAway {
    public boolean oneEditAway(String first, String second) {
        if (first.equals(second)) return true;
        if (Math.abs(first.length() - second.length()) == 1){
            String longStr;
            String shortStr;
            if (first.length() > second.length()){
                longStr = first;
                shortStr = second;
            }
            else{
                longStr = second;
                shortStr = first;
            }
            int index1 = 0;
            int index2 = 0;
            while (index1 < longStr.length() && index2 < shortStr.length()){
                if (longStr.charAt(index1) == shortStr.charAt(index2)){
                    index2 ++;
                }
                index1 ++;
                if (index1 - index2 > 1){
                    return false;
                }
            }
            return true;
        }
        else if (first.length() == second.length()){
            int count = 0;
            for (int i = 0; i < first.length(); i++) {
                if (first.charAt(i) != second.charAt(i)){
                    count ++;
                    if (count > 1) return false;
                }
            }
            return true;
        }
        else {
            return false;
        }
    }
    private int editDistance(String str1,String str2){
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else{
                    dp[i][j] = min(dp[i - 1][j] + 1,
                            dp[i][j - 1] + 1,
                            dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[m][n];
    }

    private int min(int i,int j,int k){
        return Math.min(i,Math.min(j,k));
    }
}
