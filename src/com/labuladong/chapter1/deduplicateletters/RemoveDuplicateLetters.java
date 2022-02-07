package com.labuladong.chapter1.deduplicateletters;

import java.util.*;
import java.util.stream.Collectors;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        boolean[] isExits = new boolean[256];
        int[] wordCount = new int[256];
        char[] charArray = s.toCharArray();
        for (char c : charArray){
            wordCount[c] ++;
        }
        for (int i = 0; i < charArray.length; i++) {
            wordCount[charArray[i]] --;
            if (isExits[charArray[i]]) continue;
            while (!stack.isEmpty() && charArray[i] < stack.peek()){
                //因为在循环的最一开始就执行了--操作，所以如果后续没有了该字母则跳出循环
                if (wordCount[(char)stack.peek()] == 0) break;
                Character top = stack.pop();
                isExits[top] = false;
            }
            stack.push(charArray[i]);
            isExits[charArray[i]] = true;
        }

        String collect = stack.stream().map(c -> c + "").collect(Collectors.joining());
        return new StringBuilder(collect).reverse().toString();
    }

    public static void main(String[] args) {
        RemoveDuplicateLetters rm = new RemoveDuplicateLetters();
        String s = rm.removeDuplicateLetters("bcabc");
    }
}
