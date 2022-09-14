package com.code.carl.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs){
            int[] count = new int[26];
            for (char c : str.toCharArray()){
                count[c - 'a'] ++;
            }
            //将该字符串中的所有 字母和其出现的次数拼接成key
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (count[i] != 0){
                    sb.append(((char)('a' + i)));
                    sb.append(count[i]);
                }
            }
            List<String> list = map.getOrDefault(sb.toString(), new ArrayList<>());
            list.add(str);
            map.put(sb.toString(),list);
        }
        return new ArrayList<>(map.values());
    }
}
