package com.labuladong.chapter1.slidewindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> window = new HashMap<>();
        int res = 0;
        int left = 0;
        int right = 0;
        while (right < s.length()){
            char c = s.charAt(right);
            right ++;
            window.put(c, window.getOrDefault(c,0) + 1);
            //如果某个字符出现的次数超过了1，那就证明重复了。则缩小窗口
            while (window.get(c) > 1){
                char d = s.charAt(left);
                left ++;
                //窗口中数据的更新
                window.put(d,window.get(d) - 1);
            }
            res = Math.max(res,right - left);
        }
        return res;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring l = new LengthOfLongestSubstring();
        int abcab = l.lengthOfLongestSubstring("abc");
        System.out.println(abcab);
    }
}
