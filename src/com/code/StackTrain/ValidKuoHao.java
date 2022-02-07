package com.code.StackTrain;

import java.util.Stack;

public class ValidKuoHao {
    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     */
    public boolean isValid(String s) {
        if(s == null){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        char[] array = s.toCharArray();
        for(char c : array) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if(!stack.isEmpty()){
                    char now = stack.peek();
                    if (now == '(' && c == ')') {
                        stack.pop();
                    } else if (now == '[' && c == ']') {
                        stack.pop();
                    } else if (now == '{' && c == '}') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
                else {
                    return false;
                }
            }
        }
        if(stack.size() == 0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "()[]}";
        ValidKuoHao v = new ValidKuoHao();
        System.out.println(v.isValid(s));
    }
}
