package com.code.topOnehundred;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;

public class LongestValidParentheses {
    //动态规划
    public int longestValidParentheses1(String s){
        //s = '()(())'
        //dp = [0,0,0,0,0,0]
        int[] dp = new int[s.length()];
        return 0;
    }


    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        LinkedList<Character> stack = new LinkedList<>();
        LinkedList<Integer> nums = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')'){
                if (stack.isEmpty()){
                    nums.push(0);
                }
                else {
                    stack.pop();
                    nums.push(nums.pop() + 2);
                }
            }
            else if (s.charAt(i) == '('){
                stack.push(s.charAt(i));
            }
        }
        return nums.stream().mapToInt(i -> i).max().getAsInt();
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
