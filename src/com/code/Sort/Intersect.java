package com.code.Sort;

import java.util.ArrayList;
import java.util.Arrays;

public class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> arrayList = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j]){
                arrayList.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i] < nums2[j]){
                i ++;
            }
            else{
                j ++;
            }
        }
        int[] result = new int[arrayList.size()];
        int k = 0;
        for(Integer integer : arrayList){
            result[k] = integer;
            k ++;
        }
        return result;
    }

    public static void main(String[] args) {
        Intersect intersect = new Intersect();
        System.out.println(Arrays.toString(intersect.intersect(new int[]{1,2,2,1},new int[]{2,2})));
    }
}
