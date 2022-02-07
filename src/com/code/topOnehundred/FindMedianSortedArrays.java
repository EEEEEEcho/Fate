package com.code.topOnehundred;

public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] total = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < nums1.length && j < nums2.length){
            if (nums1[i] < nums2[j]){
                total[k ++ ] = nums1[i ++];
            }
            else{
                total[k ++] = nums2[j ++];
            }
        }
        while (i < nums1.length){
            total[k++] = nums1[i ++];
        }
        while (j < nums2.length){
            total[k++] = nums2[j ++];
        }
        if (total.length % 2 == 0){
            return (((double) total[total.length / 2]) + ((double) total[total.length / 2 - 1])) / 2;
        }
        else{
            return (double) total[total.length / 2];
        }
    }
}
