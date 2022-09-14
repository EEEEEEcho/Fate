package com.code.carl.hashtable;

import java.util.HashMap;
import java.util.Map;

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] record = new int[26];
        for (char c : s.toCharArray()){
            record[c - '0'] ++;
        }
        for (char c : t.toCharArray()){
            record[c - '0'] --;
        }
        for (int i : record){
            if (i != 0) return false;
        }
        return true;
    }

}
