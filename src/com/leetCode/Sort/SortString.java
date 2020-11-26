package com.leetCode.Sort;

import com.sun.org.apache.xml.internal.security.algorithms.implementations.IntegrityHmac;

import java.util.*;

public class SortString {
    public String sortString(String s) {
        /**
         * 思路正确，但是解法很low，过于依赖语言特性
         */
        char[] array = s.toCharArray();
        Arrays.sort(array);
        Map<Character,Integer> map = new LinkedHashMap<>();
        Map<Character,Integer> maprever = new LinkedHashMap<>();
        for(int i=0;i < array.length;i ++){
            if(map.get(array[i]) == null){
                map.put(array[i],1);
            }
            else{
                map.put(array[i],map.get(array[i]) + 1);
            }
        }
        for (int i = array.length - 1;i >= 0;i --){
            if(maprever.get(array[i]) == null){
                maprever.put(array[i],1);
            }
            else{
                maprever.put(array[i],maprever.get(array[i]) + 1);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (map.size() > 0){
            for(Map.Entry<Character,Integer> entry : map.entrySet()){
                if(entry.getValue() > 0){
                    stringBuilder.append(entry.getKey());
                    int tmp = entry.getValue();
                    entry.setValue(tmp - 1);
                    maprever.put(entry.getKey(),tmp - 1);
                }
            }
            for(Map.Entry<Character, Integer> entry: maprever.entrySet()){
                if(entry.getValue() > 0){
                    stringBuilder.append(entry.getKey());
                    int tmp = entry.getValue();
                    entry.setValue(tmp - 1);
                    map.put(entry.getKey(),tmp - 1);
                }
            }
            Iterator<Map.Entry<Character,Integer>> it = map.entrySet().iterator();
            while (it.hasNext()){
                Map.Entry<Character,Integer> entry = it.next();
                if(entry.getValue() <= 0){
                    it.remove();
                }
            }
            Iterator<Map.Entry<Character,Integer>> itr = maprever.entrySet().iterator();
            while (itr.hasNext()){
                Map.Entry<Character,Integer> entry = itr.next();
                if(entry.getValue() <= 0){
                    itr.remove();
                }
            }
        }
        return stringBuilder.toString();
    }
    public String sortString2(String s){
        int[] buckets = new int[26];
        for(Character character : s.toCharArray()){
            buckets[character - 'a'] ++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (s.length() > stringBuilder.length()){
            for(int i = 0;i < 26;i ++){
                if(buckets[i] > 0){
                    stringBuilder.append((char) (i + 'a'));
                    buckets[i] --;
                }
            }
            for(int i = 25;i >= 0;i --){
                if(buckets[i] > 0){
                    stringBuilder.append((char)(i + 'a'));
                    buckets[i] --;
                }
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        SortString s = new SortString();
        System.out.println(s.sortString2("aaaabbbbcccc"));
    }
}
