package com.code.carl.array.slidewindow;

import java.util.HashMap;

public class MinWindow {
    public String minWindow(String s, String t) {
        if (s.length() < t.length())return "";
        HashMap<Character,Integer> need = new HashMap<>();
        HashMap<Character,Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        int start = 0;      //最短窗口的起点
        int valid = 0;      //有效窗口的大小
        int len = Integer.MAX_VALUE;    //有效字符串的长度
        for (char c : t.toCharArray()){
            need.put(c,need.getOrDefault(c,0) + 1);
        }
        while (right < s.length()){
            char c = s.charAt(right);
            right ++;
            //这里要注意，滑动窗口中的窗口不一定非要指的是数组中的一段
            if(need.containsKey(c)){
                //如果这个字符需要,放入窗口中扩大窗口
                window.put(c,window.getOrDefault(c,0) + 1);
                if (window.get(c).equals(need.get(c))){
                    //如果窗口中该字符串的数量达到了需要的数量
                    valid++;
                }
            }
            //缩短窗口
            while (valid == need.size()){
                //如果所有的字符都找到了，且数量满足所需的数量
                //计算当前满足所有条件的字串是不是长度更小
                if (right - left < len){
                    start = left;
                    len = right - left;
                }
                char c2Remove = s.charAt(left);
                left ++;
                //如果窗口中包含该字符
                if (need.containsKey(c2Remove)){
                    if (need.get(c2Remove).equals(window.get(c2Remove))){
                        //如果移除该字符影响了有效性
                        valid --;
                    }
                    window.put(c2Remove,window.get(c2Remove) - 1);
                }
                //如果窗口中不包含该字符，那么就不做操作，左指针向前走即可
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start,start + len);
    }

    public String minWindow2(String s, String t) {
        int left = 0;
        int right = 0;
        int len = Integer.MAX_VALUE;
        int start = 0;
        int valid = 0;
        HashMap<Character,Integer> window = new HashMap<>();
        HashMap<Character,Integer> need = new HashMap<>();
        for(char c : t.toCharArray()){
            need.put(c,need.getOrDefault(c,0) + 1);
        }
        while (right < s.length()){
            char c = s.charAt(right);
            right ++;
            //从匹配到t字符串开始
            if (need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0) + 1);
                if (window.get(c).equals(need.get(c))){
                    valid ++;
                }
            }
            //window中已经包含了t中的所有字符,尝试收缩
            while (valid == need.size()){
                if (right - left < len){
                    start = left;
                    len = right - left;
                }
                char r = s.charAt(left);
                left ++;
                if (need.containsKey(r)){
                    if (window.get(r).equals(need.get(r))){
                        valid --;
                    }
                    window.put(r,window.get(r) - 1);
                }
            }

        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start,start + len);
    }

    public static void main(String[] args) {
        MinWindow m = new MinWindow();
        m.minWindow("ADOBECODEBANC","ABC");
    }
}
