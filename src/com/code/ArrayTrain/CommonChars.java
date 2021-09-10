package com.code.ArrayTrain;

import java.util.*;

public class CommonChars {
    public List<String> commonChars(String[] words) {
        Map<Character,Integer> map = new HashMap<>();
        for(String str : words){
            for (int i = 0; i < str.length(); i++) {
                Integer num = map.get(str.charAt(i));
                if (num == null){
                    map.put(str.charAt(i),1);
                }
                else{
                    map.put(str.charAt(i),map.get(str.charAt(i))+ 1);
                }
            }
        }
        List<String> list = new LinkedList<>();
        for (Map.Entry<Character,Integer> entry : map.entrySet()){
            int times = entry.getValue() / words.length;
            for (int i = 0; i < times; i++) {
                list.add(String.valueOf(entry.getKey()));
            }
        }
        return list;
    }

}
