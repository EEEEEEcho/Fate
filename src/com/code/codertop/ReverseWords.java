package com.code.codertop;

import java.util.ArrayDeque;

public class ReverseWords {
    public String reverseWords(String s) {
        String[] strings = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            if (strings[i].length() > 0){
                sb.append(strings[i]).append(" ");
            }
        }
        return sb.toString().trim();
    }

    public String reverseWords1(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right && s.charAt(left) == ' '){
            left ++;
        }
        while (left <= right && s.charAt(right) == ' '){
            right --;
        }
        ArrayDeque<String> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        while (left <= right){
            char c = s.charAt(left);
            if ((sb.length() != 0) && (c == ' ')){
                queue.offerFirst(sb.toString());
                sb.setLength(0);
            }
            else if (c != ' '){
                sb.append(c);
            }
            left ++;
        }
        //加上最后一个单词
        queue.offerFirst(sb.toString());
        return String.join(" ",queue);
    }
}
