package com.code.ArrayTrain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindWords {
    public String[] findWords(String[] words) {
        Set<Character> set1 = new HashSet<>(Arrays.asList('q','w','e','r','t','y','u','i','o','p'));
        Set<Character> set2 = new HashSet<>(Arrays.asList('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'));
        Set<Character> set3 = new HashSet<>(Arrays.asList('z','x','c','v','b','n','m'));
        ArrayList<String> result = new ArrayList<>();
        for (String word : words){
            ArrayList<Character> tmp = new ArrayList<>();
            for (char c : word.toLowerCase().toCharArray()){
                tmp.add(c);
            }
            if (set1.containsAll(tmp) || set2.containsAll(tmp) || set3.containsAll(tmp)){
                result.add(word);
            }
        }
        return result.toArray(new String[0]);
    }
}
