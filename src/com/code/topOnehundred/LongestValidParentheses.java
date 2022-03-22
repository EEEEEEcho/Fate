package com.code.topOnehundred;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;

public class LongestValidParentheses {
    //动态规划
    public int longestValidParentheses1(String s){
        //s = '()(())'
        //dp = [0,0,0,0,0,0]
        //dp的定义是：以下标 i 字符结尾的最长有效括号的长度。
        int[] dp = new int[s.length()];
        int ans = 0;
        for (int i = 1; i < dp.length; i++) {
            //因为是求有效括号。所以只考虑 ")"的情况
            if (s.charAt(i) == ')'){
                if(s.charAt(i - 1) == '('){
                    dp[i] = i - 2 >= 0 ? dp[i - 2]  + 2: 2;
                }
                else if(s.charAt(i - 1) == ')'){
                    //如果i - 1 是 ')' 那么需要判断在i-1之前，是否有一个 ( 与当前 i 的 ) 匹配，匹配的话长度再加2
                    if(i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '('){
                        //dp[i-1]是前i-1个字符串中的最长有效括号的长度,
                        //i - dp[i - 1] - 2是前一个最长的有效括号长度
                        dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                    }
                }
                ans = Math.max(ans,dp[i]);
            }
        }
        return ans;
    }


    public int longestValidParentheses(String s) {
        int maxans = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                //如果当前为 ( 那么直接入栈
                stack.push(i);
            }
            else{
                //遇到 )
                //先弹出来一个左括号。因为最开始插入了一个-1所以处理了边界
                stack.pop();
                if(stack.isEmpty()){
                    //如果这时栈空。那么把 ) 的下标放进去
                    stack.push(i);
                }
                else{
                    //这时栈不为空计算最长有效括号
                    maxans = Math.max(maxans,i - stack.peek());

                }
            }
        }
        return maxans;
    }

    public static void main(String[] args) throws IOException {
//        LongestValidParentheses l = new LongestValidParentheses();
//        int i = l.longestValidParentheses("(()");
//        System.out.println(i);
//        long round = Math.round(-0.5);
//        System.out.println(round);
//        boolean exists = Files.exists(Paths.get("G://Redis.pdf"));
//        System.out.println(exists);
//        byte[] bytes = Files.readAllBytes(Paths.get("G://Redis.pdf"));
//        System.out.println(Arrays.toString(bytes));
    }
}
