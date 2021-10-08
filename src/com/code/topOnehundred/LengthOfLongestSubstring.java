package com.code.topOnehundred;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 滑动窗口，这道题没做出来，主要出问题在去重的地方
 * abcabcbb
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1){
            return s.length();
        }
        int start = 0;
        int max = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)){
                //如果有该值，左窗口直接跳转至该值最后出现的地方的下一位
                start = Math.max(map.get(c) + 1 ,start);
            }
            max = Math.max(i - start + 1,max);
            map.put(c,i);
        }
        return max;
    }
}
