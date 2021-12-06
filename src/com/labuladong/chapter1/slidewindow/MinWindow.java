package com.labuladong.chapter1.slidewindow;

import java.util.HashMap;

public class MinWindow {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> window = new HashMap<>();
        HashMap<Character,Integer> need = new HashMap<>();
        char[] chars = t.toCharArray();
        for (char c : chars) need.put(c,need.getOrDefault(c,0) + 1);
        int left = 0;
        int right = 0;
        int valid = 0;

        //记录最小子串的起始位置和长度
        int start = 0,len = Integer.MAX_VALUE;

        while (right < s.length()){
            char c = s.charAt(right);
            //向右移动窗口
            right ++;
            //如果该字符是目标字符
            if (need.containsKey(c)){
                //窗口中也放进去
                window.put(c, window.getOrDefault(c,0) + 1);
                if(need.get(c).equals(window.get(c))){
                    //如果window中该字符出现的次数够了
                    valid ++;   //该字符满了
                }
            }

            //判断左侧窗口是否要收缩
            while (valid == need.size()){
                //如果所有字符都找到了
                //在这里更新最小覆盖子串
                if(right - left < len){
                    start = left;
                    len = right - left;
                }

                //这是要移除的字符
                char c2remove = s.charAt(left);
                //向左移动
                left ++;
                if (need.containsKey(c2remove)){
                    if (window.get(c2remove).equals(need.get(c2remove))){
                        valid --;
                    }
                    window.put(c2remove, window.get(c2remove) - 1);
                }
            }

        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start,start + len);
    }

    public static void main(String[] args) {
        MinWindow minWindow = new MinWindow();
        String s = minWindow.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s);
    }
}
