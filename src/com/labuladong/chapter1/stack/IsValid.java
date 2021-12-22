package com.labuladong.chapter1.stack;

import java.util.LinkedList;

public class IsValid {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : chars){
            if (c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }
            else{
                if (!stack.isEmpty() && leftOf(c) == stack.peek()){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    private char leftOf(char c){
        if (c == ')') return '(';
        else if(c == ']') return '[';
        else return '{';
    }
}
