package com.thinkInJava.chapter20;

import java.util.*;

@ExtractInterface("IMultiplier")
public class Multiplier {
    public int multiply(int x,int y){
        int total = 0;
        for(int i=0;i < x;i ++){
            total = add(total,y);
        }
        return total;
    }
    private int add(int x,int y){
        return x + y;
    }
    public static String[] findWords(String[] words) {
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
    public static void main(String[] args) {
        Multiplier multiplier = new Multiplier();
        System.out.println("11 * 16 = " + multiplier.multiply(11,16));
        // ["Hello","Alaska","Dad","Peace"]
        String[] nums = new String[]{"Hello","Alaska","Dad","Peace"};
        System.out.println(Arrays.toString(findWords(nums)));
    }


}
