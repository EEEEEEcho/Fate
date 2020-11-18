package com.leetCode.Sort;

import java.util.*;

public class SortString {
    public String sortString(String s) {

        char[] array = s.toCharArray();
        Arrays.sort(array);
        Map<Character,Integer> map = new LinkedHashMap<>();
        for(Character character : array){
            if (map.get(character) == null) {
                map.put(character, 1);
            } else {
                map.put(character, map.get(character) + 1);
            }
        }
        StringBuilder sb = new StringBuilder();

        while (map.size() > 0){

            for(Map.Entry<Character,Integer> entry : map.entrySet()){

                if(entry.getValue() == 0){
                    map.remove(entry.getKey());
                }
                else{
                    sb.append(entry.getKey());
                    map.put(entry.getKey(),entry.getValue() - 1);
                }
            }
            if(map.size() > 0){
                ListIterator<Map.Entry<Character,Integer>> iterator = new ArrayList<Map.Entry<Character,Integer>>(map.entrySet()).listIterator(map.size());
                while (iterator.hasPrevious()){
                    Map.Entry<Character,Integer> entry = iterator.previous();
                    if(entry.getValue() == 0){
                        map.remove(entry.getKey());
                    }
                    else{
                        sb.append(entry.getKey());
                        map.put(entry.getKey(),entry.getValue() - 1);
                    }
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SortString s = new SortString();
        System.out.println(s.sortString("aaaabbbbcccc"));
    }
}
