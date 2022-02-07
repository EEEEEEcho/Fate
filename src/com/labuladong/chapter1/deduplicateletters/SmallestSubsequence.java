package com.labuladong.chapter1.deduplicateletters;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class SmallestSubsequence {
    public String smallestSubsequence(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        int[] count = new int[256];
        boolean[] isExist = new boolean[256];
        char[] charArray = s.toCharArray();
        for (char c : charArray){
            count[c] ++;
        }
        for(char c : charArray){
            count[c] --;
            if (isExist[c]) continue;
            while (!stack.isEmpty() && stack.peek() > c){
                if (count[c] == 0) break;
                Character top = stack.pop();
                isExist[top] = false;
            }
            stack.push(c);
            isExist[c] = true;
        }
        String collect = stack.stream().map(c -> c + "").collect(Collectors.joining());
        return new StringBuilder(collect).reverse().toString();
    }
}
