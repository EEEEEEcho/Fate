package com.code.ArrayTrain;

import java.util.*;

public class ShortestToChar {
//    public int[] shortestToChar(String s, char c) {
//        List<Integer> cIndex = new ArrayList<>();
//        for (int i = 0; i < s.length(); i++) {
//            if (c == s.charAt(i)){
//                cIndex.add(i);
//            }
//        }
//        int[] result = new int[s.length()];
//        int start = 0;
//        for (int i = 0;i < s.length();i ++){
//            if (i < cIndex.get(0)){
//                result[i] = Math.abs(cIndex.get(0) - i);
//            }
//            else if (i > cIndex.get(cIndex.size() - 1)){
//                result[i] = Math.abs(i - cIndex.get(cIndex.size() - 1));
//            }
//            else{
//                result[i] = Math.min(Math.abs(cIndex.get(start) - i),Math.abs(cIndex.get(start + 1) - i));
//                if (i == cIndex.get(start)){
//                    start ++;
//                }
//            }
//        }
//        return result;
//    }

    public int[] shortestToChar(String s, char c) {
        int[] result = new int[s.length()];
        int pre = Integer.MIN_VALUE / 2;
        for (int i = 0;i < s.length();i ++){
            if (s.charAt(i) == c){
                pre = i;
            }
            result[i] = i - pre;
        }
        pre = Integer.MAX_VALUE / 2;
        for (int i = s.length() - 1;i >= 0;i --){
            if (s.charAt(i) == c){
                pre = i;
            }
            result[i] = Math.min(result[i],pre - i);
        }
        return result;
    }

    public static void main(String[] args) {
        ShortestToChar s = new ShortestToChar();
        System.out.println(Arrays.toString(s.shortestToChar("abba",'a')));
    }
}
