package com.code.carl.hashtable;

public class CanConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        int[] need = new int[26];
        int[] give = new int[26];
        for (char c : ransomNote.toCharArray()){
            need[c - 'a'] ++;
        }
        for (char c : magazine.toCharArray()){
            give[c - 'a'] ++;
        }
        for (int i = 0;i < need.length;i ++){
            if (need[i] > give[i]) return false;
        }
        return true;
    }
}
