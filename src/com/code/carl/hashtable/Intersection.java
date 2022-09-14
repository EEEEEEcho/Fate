package com.code.carl.hashtable;

import java.util.ArrayList;
import java.util.HashSet;

public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums1){
            set.add(i);
        }
        HashSet<Integer> set2 = new HashSet<>();
        for(int i : nums2){
            set2.add(i);
        }
        set.retainAll(set2);
        int[] ans = new int[set.size()];
        int i = 0;
        for (int num : set){
            ans[i ++] = num;
        }
        return ans;
    }
}
