package com.labuladong.chapter1.slidewindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        Map<Character,Integer> needs = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();
        for(char c : p.toCharArray()) needs.put(c,needs.getOrDefault(c,0) + 1);
        int left = 0;
        int right = 0;
        int valid = 0;
        while (right < s.length()){
            char c = s.charAt(right);
            right ++;
            if (needs.containsKey(c)){
                window.put(c, window.getOrDefault(c,0) + 1);
                if(window.get(c).equals(needs.get(c))){
                    valid ++;
                }
            }

            while (right - left >= p.length()){
                if (needs.size() == valid){
                    result.add(left);
                }
                char d = s.charAt(left);
                left ++;
                if (needs.containsKey(d)){
                    if(window.get(d).equals(needs.get(d))){
                        valid --;
                    }
                    window.put(d, window.getOrDefault(d,0) - 1);
                }
            }
        }
        return result;
    }
}
