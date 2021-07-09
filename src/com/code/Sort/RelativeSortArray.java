package com.code.Sort;

import java.util.*;

public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < arr1.length; i++) {
            if (map.get(arr1[i]) == null) {
                map.put(arr1[i], 1);
            } else {
                map.put(arr1[i], map.get(arr1[i]) + 1);
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < arr2.length; i++) {
            int times = map.get(arr2[i]);
            while (times-- > 0) {
                arrayList.add(arr2[i]);
            }
            map.remove(arr2[i]);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int times = entry.getValue();
            if (times != 0){
                while (times -- > 0){
                    arrayList.add(entry.getKey());
                }
            }
        }
        int[] result = new int[arrayList.size()];
        int i = 0;
        for(Integer integer: arrayList){
            result[i ++] = integer;
        }
        return result;
    }

    public static void main(String[] args) {
        RelativeSortArray r = new RelativeSortArray();
        r.relativeSortArray(new int[]{2,21,43,38,0,42,33,7,24,13,12,27,12,24,5,23,29,48,30,31}, new int[]{2,42,38,0,43,21});
    }
}
