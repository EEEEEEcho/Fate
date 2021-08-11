package com.code.ArrayTrain;

import java.util.*;

public class ShortestToChar {
    public int[] shortestToChar(String s, char c) {
        List<Integer> cIndex = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (c == s.charAt(i)){
                cIndex.add(i);
            }
        }
        int[] result = new int[s.length()];
        int start = 0;

        for (int i = 0;i < s.length();i ++){
            if (i < cIndex.get(0)){
                result[i] = Math.abs(cIndex.get(0) - i);
            }
            else if (i > cIndex.get(cIndex.size() - 1)){
                result[i] = Math.abs(i - cIndex.get(cIndex.size() - 1));
            }
            else{

            }
        }
        return result;
    }

    public static void main(String[] args) {
        ShortestToChar s = new ShortestToChar();
        System.out.println(Arrays.toString(s.shortestToChar("abba",'b')));
    }
}
