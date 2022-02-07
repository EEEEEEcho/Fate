package com.code.topOnehundred;

public class LongestPalindrome {
    //中心扩散
    public String longestPalindrome1(String s) {
        if (s.length() == 1) return s;
        int start = 0,maxLength = 0;
        int i = 0;
        int len = s.length();
        while (i < len){
            if (len - i < maxLength / 2) break;
            int left = i;
            int right = i;
            while (right + 1 < len && s.charAt(right) == s.charAt(right + 1)){
                right ++;
            }
            i = right;
            while (left > 0 && right < len - 1 && s.charAt(left - 1) == s.charAt(right + 1)){
                left --;
                right ++;
            }
            if (right - left + 1 > maxLength){
                maxLength = right - left + 1;
                start = left;
            }
            i ++;
        }
        return s.substring(start,start + maxLength);
    }
    //动态规划
    //一个回文串掐头去尾之后仍是回文串
    //dp[i][j] 代表字符串 s[i..j] 是否为回文串 true 是， false 否
    //dp[i][j] = (s[i] == s[j]) && dp[i + 1][j - 1](掐头去尾)
    //边界条件：(j - 1) - (i + 1) + 1 < 2 ,即字符串最少包含一个字符。 ->   j - i < 3
    //对角线的元素不参与判断
    public String longestPalindrome2(String s){
        if (s.length() < 2) return s;
        int len = s.length();
        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[len][len];
        //对角线元素不参与判断
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        //按列填充，保证左下角的元素是计算出来的
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                //如果头尾不同，不是回文串
                if (s.charAt(i) != s.charAt(j)){
                    dp[i][j] = false;
                }
                else{
                    if (j - i < 3){
                        //不符合边界条件
                        dp[i][j] = true;
                    }
                    else{
                        //如果掐头去尾是回文，且判断过了头尾相同，那么就是回文
//                        if (dp[i + 1][j - 1]){
//                            dp[i][j] = true;
//                        }
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && j - i + 1 > maxLen){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin + maxLen);
    }

    public String longestPalindrome3(String s) {
        String ans = "";
//        String[] dp = new String[s.length()];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                String tmp = s.substring(j,i + 1);
                //暴力，注意剪枝，多动脑
                if (tmp.length() < max){
                    break;
                }
                if (isPalindrome(tmp) && tmp.length() > max){
                    max = tmp.length();
                    ans = tmp;
                }
            }
        }
        return ans;
    }
    public boolean isPalindrome(String s){
        int i = 0;
        int j = s.length() - 1;
        while (i <= j){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
            i ++;
            j --;
        }
        return true;
    }

    public static void main(String[] args) {
        LongestPalindrome l = new LongestPalindrome();
        String ab = l.longestPalindrome1("cbbd");
        System.out.println(ab);
    }
}
