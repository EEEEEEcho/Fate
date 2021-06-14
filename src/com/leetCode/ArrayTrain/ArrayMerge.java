package com.leetCode.ArrayTrain;

import java.util.Arrays;

public class ArrayMerge {
    public void merge(int[] nums1, int m, int[] nums2, int n){
        if (n >= 0) System.arraycopy(nums2, 0, nums1, m - 1, n);
        Arrays.sort(nums1);
    }
}
