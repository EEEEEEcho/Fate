package com.code.ArrayTrain;

import java.util.*;

public class CommonChars {
    public List<String> commonChars(String[] words) {
        int[] min = new int[26];
        Arrays.fill(min,Integer.MAX_VALUE);
        for (String str : words){
            int[] temp = new int[26];
            for (int i = 0; i < str.length(); i++) {
                temp[str.charAt(i) - 'a'] ++;
            }
            for (int i = 0;i < 26;i ++){
                min[i] = Math.min(min[i],temp[i]);
            }
        }
        List<String> result = new ArrayList<>();
        for (int i = 0;i < 26;i ++){
            for (int j = 0; j < min[i]; j++) {
                result.add(String.valueOf((char)(i + 'a')));
            }
        }
        return result;
//        Map<Character,Integer> map = new HashMap<>();
//        for(String str : words){
//            for (int i = 0; i < str.length(); i++) {
//                Integer num = map.get(str.charAt(i));
//                if (num == null){
//                    map.put(str.charAt(i),1);
//                }
//                else{
//                    map.put(str.charAt(i),map.get(str.charAt(i))+ 1);
//                }
//            }
//        }
//        List<String> list = new LinkedList<>();
//        for (Map.Entry<Character,Integer> entry : map.entrySet()){
//            int times = entry.getValue() / words.length;
//            for (int i = 0; i < times; i++) {
//                list.add(String.valueOf(entry.getKey()));
//            }
//        }
//        return list;
    }

    public static void main(String[] args) {
        String s = "abcd";
        System.out.println(s.charAt(3));
    }
}
