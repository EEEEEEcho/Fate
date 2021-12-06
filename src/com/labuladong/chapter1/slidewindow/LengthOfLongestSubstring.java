package com.labuladong.chapter1.slidewindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
//        Map<Character,Integer> needs = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();
        int res = 0;
        int left = 0;
        int right = 0;
//        int valid = 0;
        while (right < s.length()){
            char c = s.charAt(right);
            right ++;
            if (!window.containsKey(c)){
                window.put(c,right - 1);
            }
            else{
                res = Math.max(res,right - left);
                left = window.get(c);
            }
        }
        return res;
    }
}
