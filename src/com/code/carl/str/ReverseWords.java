package com.code.carl.str;

import java.util.Collections;

public class ReverseWords {
    public String reverseWords(String s) {
        s = s.trim();
        String[] strings = s.split(" ");

        StringBuilder sb = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            if (!"".equals(strings[i])){
                sb.append(strings[i]);
            }
        }
        return sb.toString();
    }
}
