package com.code.carl.hashtable;

import java.util.*;

public class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map1 = new HashMap<>();
        HashMap<Integer,Integer> map2 = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums1){
            map1.put(num,map1.getOrDefault(num,0) + 1);
        }
        for (int num : nums2){
            map2.put(num,map2.getOrDefault(num,0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            if (map2.containsKey(entry.getKey())){
                int min = Math.min(entry.getValue(),map2.get(entry.getKey()));
                for (int i = 0; i < min; i++) {
                   list.add(entry.getKey());
                }
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }


    public int[] intersect1(int[] nums1, int[] nums2){
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index1 = 0;
        int index2 = 0;
        List<Integer> list = new ArrayList<>();
        while (index1 < nums1.length && index2 < nums2.length){
            if (nums1[index1] < nums2[index2]){
                index1 ++;
            }
            else if(nums2[index2] < nums1[index1]){
                index2 ++;
            }
            else{
                list.add(nums1[index1]);
                index1 ++;
                index2 ++;
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

}
