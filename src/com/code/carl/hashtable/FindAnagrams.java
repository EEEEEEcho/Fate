package com.code.carl.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer> need = new HashMap<>();
        HashMap<Character,Integer> window = new HashMap<>();
        int valid = 0;
        for (char c : p.toCharArray()){
            need.put(c,need.getOrDefault(c,0) + 1);
        }
        int left = 0;
        int right = 0;
        List<Integer> ans = new ArrayList<>();
        while (right < s.length()){
            char c = s.charAt(right);
            right ++;
            //从大串中找小串的套路一般都是这样的，只要need包含该字符再添加
            if (need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0) + 1);
                if (window.get(c).equals(need.get(c))){
                    valid ++;
                }
            }

            //收缩窗口的条件：窗口长度大于被匹配串
            while (right - left >= p.length()){
                if (valid == need.size()){
                    ans.add(left);
                }
                char cRemove = s.charAt(left);
                left ++;
                //无论扩充还是收缩，都是要拿need开刀的
                if (need.containsKey(cRemove)){
                    if (need.get(cRemove).equals(window.get(cRemove))){
                        valid --;
                    }
                    window.put(cRemove,window.get(cRemove) - 1);
                }
            }
        }
        return ans;
    }
}
