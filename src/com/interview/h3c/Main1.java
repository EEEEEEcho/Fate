package com.interview.h3c;

public class Main1 {
    public String reverseWords(String s){
        if (s == null || s.length() == 0) return s;
        String[] s1 = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String str: s1){
            StringBuilder builder = new StringBuilder(str);
            sb.append(builder.reverse()).append(" ");
        }
        return sb.toString().trim();
    }
}
