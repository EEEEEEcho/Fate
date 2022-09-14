package com.interview.ms;

import java.util.*;

public class Main {
    public static class Data{
        char value;
        int times;
        public Data(char value,int times){
            this.value = value;
            this.times = times;
        }
    }
    public String solution(String S) {
        // write your code in Java 8 (Java SE 8)
        if (S.length() == 1){
            return S;
        }
        TreeMap<Character,Integer> map = new TreeMap<>(Comparator.reverseOrder());
        for (char c : S.toCharArray()){
            map.put(c,map.getOrDefault(c,0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        Character maxOdd = null;
        for (Map.Entry<Character,Integer> entry : map.entrySet()){
            int times = entry.getValue();
            if (times / 2 > 0){
                if (sb.length() == 0 && entry.getKey().equals('0')){
                    continue;
                }
                for (int i = 0; i < times / 2; i++) {
                    sb.append(entry.getKey());
                }
            }
            if (times % 2 != 0){
                if (maxOdd == null){
                    maxOdd = entry.getKey();
                }
            }
        }
        if (sb.length() > 0){
            StringBuilder res = new StringBuilder(sb);
            if (maxOdd != null){
                sb.append(maxOdd);
            }
            sb.append(res.reverse());
        }
        else{
            if (maxOdd != null){
                sb.append(maxOdd);
            }
            else{
                sb.append('0');
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Main main = new Main();
        String solution = main.solution("0000");
        System.out.println(solution);
    }
//    public static void main(String[] args) {
//
//    }
}
