package com.code.ArrayTrain;

import java.util.*;

public class HasGroupsSizeX {
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length < 2){
            return false;
        }
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (Integer item : deck){
            map.merge(item, 1, Integer::sum);
        }

        int start = map.get(map.firstKey());

        for (Map.Entry entry : map.entrySet()){
            start = gcd(start, (Integer) entry.getValue());
            if (start == 1){
                return false;
            }
        }
        return true;
    }

    public int gcd(int x,int y){
        if (x < y){
            int temp = x;
            x = y;
            y = temp;;
        }
        while (x % y != 0){
            int temp = y;
            y = x % y;
            x = temp;
        }
        return y;
    }

    public static void main(String[] args) {
        HasGroupsSizeX h = new HasGroupsSizeX();
        System.out.println(h.gcd(4,4));

        Map<Integer,Integer> map = new HashMap<>();
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry entry : entries){
            Object value = entry.getValue();
        }
    }
}
