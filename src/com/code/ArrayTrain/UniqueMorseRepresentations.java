package com.code.ArrayTrain;

import java.util.HashSet;

public class UniqueMorseRepresentations {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = new String[]{
                ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."
        };
        HashSet<String> hashSet = new HashSet<>();
        for (String word: words){
            char[] chars = word.toCharArray();
            StringBuilder builder = new StringBuilder();
            for (Character character : chars){
                builder.append(morse[((int)character) - 97]);
            }
            hashSet.add(builder.toString());
        }
        return hashSet.size();
    }

    public static void main(String[] args) {
        UniqueMorseRepresentations u = new UniqueMorseRepresentations();
        u.uniqueMorseRepresentations(new String[]{"aaa"});
    }
}
