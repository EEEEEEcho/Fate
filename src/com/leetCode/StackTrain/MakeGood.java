package com.leetCode.StackTrain;

import java.util.Stack;

public class MakeGood {
    public String makeGood(String s) {
        Stack<String> stack = new Stack<>();
        String tmp;
        for(int i = 0;i < s.length();i ++){
            tmp = String.valueOf(s.charAt(i));
            if(stack.isEmpty()){
                stack.push(tmp);
            }
            else if((!stack.peek().equals(tmp)) &&
                    ((stack.peek().toLowerCase().equals(tmp)) ||
                    (stack.peek().equals(tmp.toLowerCase())))){
                stack.pop();
            }
            else {
                stack.push(tmp);
            }
        }
        StringBuilder result = new StringBuilder();
        for(String string : stack){
            result.append(string);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        MakeGood makeGood = new MakeGood();
        System.out.println(makeGood.makeGood("leEeetcode"));
    }
}
