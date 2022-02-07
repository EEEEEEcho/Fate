package com.code.topOnehundred;

public class IsMatch {
    /**
     * 动态规划
     * dp[i][j] = s 的前 i 个是否能被 p 的前 j 个匹配
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p){
        return true;
    }
    /**
     * 这就不是一道字符串匹配的问题
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch1(String s, String p) {
        int sIndex = 0;
        int pIndex = 0;
        while (sIndex < s.length()){
            if (pIndex >= p.length()) return false;
            char c = s.charAt(sIndex);
            char m = p.charAt(pIndex);
            if(m == '.' || c == m){
                sIndex ++;
                pIndex ++;
            }
            else if (m == '*'){
                if (pIndex - 1 >= 0){
                    char h = p.charAt(pIndex - 1);
                    while (sIndex < s.length() && (s.charAt(sIndex) == h || h == '.')){
                        sIndex ++;
                    }
                    pIndex ++;
                }
            }
            else{
                if (pIndex + 1 < p.length() && p.charAt(pIndex + 1) == '*'){
                    pIndex += 2;
                }
                else{
                    return false;
                }
            }
        }
        if (pIndex < p.length()){
            int i = p.lastIndexOf('*');
            if (i > 0){
                return p.charAt(i + 1) == p.charAt(i - 1);
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        IsMatch match = new IsMatch();
        boolean match1 = match.isMatch("aaa", "a*a");
        System.out.println(match1);
    }
}
