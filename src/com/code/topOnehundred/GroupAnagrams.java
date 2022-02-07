package com.code.topOnehundred;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {
    //可过，但是效率不高
    public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<Anagrams> list = new ArrayList<>();
        for (String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            StringBuilder temp = new StringBuilder();
            for (char c : chars){
                temp.append(c);
            }
            list.add(new Anagrams(temp.toString(),str));
        }
        Map<String, List<String>> collect = list.stream().collect(Collectors.groupingBy(Anagrams::getKey, Collectors.mapping(Anagrams::getValue, Collectors.toList())));
        return new ArrayList<>(collect.values());
    }


    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        List<List<String>> lists = groupAnagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(lists);
    }
}
class Anagrams{
    String key;
    String value;
    public Anagrams(String key,String value){
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Anagrams{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
