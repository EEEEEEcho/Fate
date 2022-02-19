package com.labuladong.chapter4.dynamic;

import java.util.HashMap;

public class IsMatch {

    public boolean isMatch(String s, String p) {
        return dp(s,0,p,0);
    }

    private HashMap<String,Boolean> memo = new HashMap<>();
    //dp函数表示：
    //dp(s,i,p,j)为true 表示 s[i...] 能够匹配 p[j...]
    //dp(s,i,p,j)为false 表示 s[i...] 不能够匹配 p[j...]
    public boolean dp(String s,int i,String p,int j){
        int m = s.length();
        int n = p.length();
        //base case
        //p到头了，看看s到头没有
        if (j == p.length()){
            return i == s.length();
        }
        //s到头了，虽然s到头了，但是不能单纯的判断 p 是否到头
        //因为p没有到头也可以完整匹配s ，比如说：s = b  p = b*a*c
        if (i == s.length()){
            //假如说 i = 0 即 s为空串的情况下
            //能匹配空串的肯定是 形如.*  a* b* 之类的，一定是一个双数串
            //如果 s 是空串，那么肯定p还没有匹配，j - n 就是p的长度
            if ((j - n) % 2 != 0){
                return false;
            }

            //否则查看是否有形如a*b*c*d*类似的情况。因为题目要求只规定了类似的情况
            for (;j + 1 < p.length();j += 2){
                if (p.charAt(j + 1) != '*'){
                    return false;
                }
            }
            return true;
        }
        String key = s.substring(i,m) + "," + s.substring(j,n);
        if (memo.containsKey(key)){
            return memo.get(key);
        }
        boolean res = false;
        //匹配了
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'){
            //看看p后面的一个字符是不是*
            if (j + 1 < p.length() && p.charAt(j + 1) == '*'){
                //如果是，那么有两种情况，一种是p的当前位置不同，继续向后匹配s eg: s = 'aaa' p = 'a*'
                //或者，s不动，p向后两位，从*的下一个开始 eg:s = aa   p = a*aa
                res = dp(s,i + 1,p,j) || dp(s,i,p,j + 2);
            }
            else{
                //不是的话，正常匹配
                res = dp(s,i + 1,p,j + 1);
            }
        }
        else{
            //不匹配可能是其他情况导致的，比如 s = a p = b*a 首先排除这种情况
            if (j + 1 < p.length() && p.charAt(j + 1) == '*'){
                res = dp(s,i,p,j + 1);
            }
        }
        memo.put(key,res);
        return res;
    }
}
