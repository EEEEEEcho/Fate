package com.labuladong.chapter1.slidewindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CheckInclusion {
    //笨方法
    //s1 = "ab" s2 = "eidbaooo"
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer> needs = new HashMap<>();
        char[] chars = s1.toCharArray();
        for(char c : chars) needs.put(c,needs.getOrDefault(c,0) + 1);

        int left = 0;
        int right = s1.length();

        while (right <= s2.length()){
            String s = s2.substring(left,right);
            HashMap<Character,Integer> window = new HashMap<>();
            char[] array = s.toCharArray();
            for (char c : array) window.put(c,window.getOrDefault(c,0) + 1);
            int count = 0;
            if (window.keySet().containsAll(needs.keySet())){
                for (Map.Entry entry : needs.entrySet()){
                    if (window.get(entry.getKey()).equals(entry.getValue())) count++;
                }
                if (count == needs.size()) return true;
            }
            left ++;
            right ++;
        }
        return false;
    }

    //滑动窗口的好办法
    public boolean checkInclusion1(String s1, String s2) {
        HashMap<Character,Integer> need = new HashMap<>();
        HashMap<Character,Integer> window = new HashMap<>();
        for(char c : s1.toCharArray()) need.put(c,need.getOrDefault(c,0) + 1);

        int left = 0;
        int right = 0;
        int valid = 0;
        while (right < s2.length()){

            char c2Add = s2.charAt(right);
            right ++;
            //窗口数据的更新
            if(need.containsKey(c2Add)){
                window.put(c2Add, window.getOrDefault(c2Add,0) + 1);
                if(window.get(c2Add).equals(need.get(c2Add))){
                    valid ++;
                }
            }

            //判断窗口是否收缩
            while (right - left >= s1.length()){
                //判断是否找到了合法的子串
                if (valid == need.size()){
                    return true;
                }
                char c2Remove = s2.charAt(left);
                left ++;
                if (need.containsKey(c2Remove)){
                    if(window.get(c2Remove).equals(need.get(c2Remove))){
                        valid --;
                    }
                    window.put(c2Remove,window.get(c2Remove) - 1);
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        CheckInclusion c = new CheckInclusion();
        boolean b = c.checkInclusion("adc", "dcda");
        System.out.println(b);
    }
}
