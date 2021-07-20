package com.code.ArrayTrain;

import java.util.*;

public class LongestWord {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> hashSet = new TreeSet<String>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()){
                    return o1.compareTo(o2);
                }
                else{
                    return o2.length() - o1.length();
                }
            }
            
        });
        for (int i = 1; i < words.length; i++) {
            if (i == words.length - 1 && words[i].contains(words[i - 1])){
                hashSet.add(words[i]);
            }
            if (!words[i].contains(words[i - 1])){
                hashSet.add(words[i - 1]);
            }
        }
        Iterator<String> iterator = hashSet.iterator();
        return iterator.next();
    }

    public static void main(String[] args) {
        LongestWord longestWord = new LongestWord();
        String test[] = new String[]{
                "a","banana","app","appl","ap","apply","apple"
        };
        String s = longestWord.longestWord(test);
        System.out.println(s);
    }
}
