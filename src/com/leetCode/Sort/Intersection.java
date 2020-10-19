package com.leetCode.Sort;

import java.util.*;

public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> result = new TreeSet<>();
        Set<Integer> set1 = new TreeSet<>();
        for(Integer integer : nums1){
            set1.add(integer);
        }
        Set<Integer> set2 = new TreeSet<>();
        for(Integer integer : nums2){
            set2.add(integer);
        }
        result.addAll(set1);
        result.retainAll(set2);
        nums1 = new int[result.size()];
        int i = 0;
        for(Integer integer:result){
            nums1[i] = integer;
            i ++;
        }
        return nums1;
    }

    public static void main(String[] args) {
        Intersection intersection = new Intersection();
        intersection.intersection(new int[]{1,2,3},new int[]{3,4,5});
    }
}
