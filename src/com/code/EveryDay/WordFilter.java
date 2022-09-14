package com.code.EveryDay;

import java.util.HashMap;
import java.util.HashSet;

public class WordFilter {
    private String[] words;
    private HashMap<String,Integer> hashMap = new HashMap<>();
    public WordFilter(String[] words) {
        this.words = words;
    }

    public int f(String pref, String suff) {
        if (hashMap.containsKey(pref + "," + suff)){
            return hashMap.get(pref + "," + suff);
        }
        else{
            int index = -1;
            for (int i = 0; i < words.length; i++) {
                if (words[i].startsWith(pref) && words[i].endsWith(suff)){
                    index = i;
                }
            }
            if (index != -1) hashMap.put(pref + "," + suff,index);
            return index;
        }
    }
}
