package com.labuladong.chapter1.stack;

import java.util.LinkedList;

public class MinAddToMakeValid {
    public int minAddToMakeValid(String s) {
        int right = 0;
        LinkedList<Character> stack = new LinkedList<>();
        char[] charArray = s.toCharArray();
        for (char c : charArray){
            if (c == '(') stack.push(c);
            else {
                if (stack.isEmpty()){
                    right ++;
                }
                else{
                    stack.pop();
                }
            }
        }
        return right + stack.size();
    }

    //labuladong
    public int minAddToMakeVali2(String s) {
        int left = 0;
        int right = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') right ++;
            if (chars[i] == ')'){
                right --;
                if (right == -1){
                    right = 0;
                    left ++;
                }
            }
        }
        return left + right;
    }
}
