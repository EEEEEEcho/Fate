package com.interview.h3c;

import java.util.HashSet;

public class Main2 {
    public boolean isUnique(String str){
        HashSet<Character> hashSet = new HashSet<>();
        for (Character c : str.toCharArray()){
            hashSet.add(c);
        }
        return hashSet.size() == str.length();
    }


}
