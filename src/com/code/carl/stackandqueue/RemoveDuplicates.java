package com.code.carl.stackandqueue;

import java.util.ArrayDeque;
import java.util.Collections;

public class RemoveDuplicates {
    public String removeDuplicates(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        for (char c : chars){
            if (stack.size() > 0){
                Character top = stack.peek();
                if (!top.equals(c)){
                    stack.push(c);
                }
                else{
                    stack.pop();
                }
            }
            else{
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder("");
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        removeDuplicates.removeDuplicates("abbaca");
    }
}
