package com.code.ArrayTrain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class IsAlienSorted {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character,Integer> map = new HashMap<>();
        String[] tmp = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            tmp[i] = words[i];
        }
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i),i + 1);
        }
        Arrays.sort(words, (o1, o2) -> {
            int i = 0;
            int j = 0;
            while (i < o1.length() && j < o2.length()){
                if (map.get(o1.charAt(i)) != map.get(o2.charAt(j))){
                    return map.get(o1.charAt(i)) - map.get(o2.charAt(j));
                }
                i++;
                j++;
                if (i == o1.length() && j < o2.length()){
                    return  -1;
                }
                if (j == o2.length() && i < o1.length()){
                    return 1;
                }
            }
            return 0;
        });
        for (int i = 0; i < words.length; i++) {
            if (!words[i].equals(tmp[i])){
                return false;
            }
        }
        return true;
    }

    public boolean isAlienSorted2(String[] words, String order) {
        //有序是有传递性的
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i),i + 1);
        }
//        for (int i = 0; i < words.length - 1; i++) {
//            if (words[i].compareTo())
//        }
        return true;
    }

    public static void main(String[] args) {
        IsAlienSorted i = new IsAlienSorted();
        boolean sorted = i.isAlienSorted(new String[]{"apple", "app"}, "abcdefghijklmnopqrstuvwxyz");
        System.out.println(sorted);
    }
}
