package com.leetCode.StackTrain;

import java.util.Stack;

public class RemoveDuplicates {
    public String removeDuplicates(String S) {
        char array[] = S.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i=0;i < array.length;i ++){
            if(!stack.isEmpty() && stack.peek() == array[i]){
                stack.pop();
            }
            else{
                stack.push(array[i]);
            }
        }
        String result = "";
        while (!stack.isEmpty()){
            result += Character.toString(stack.pop());
        }
        return new StringBuilder((result)).reverse().toString();
    }
}
