package com.leetCode.ArrayTrain;

import java.util.Arrays;

public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int result = Arrays.binarySearch(nums,target);
        if (result >= 0) {
            return  result;
        }
        else{
            return (-result) - 1;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,3,5};
        int i = Arrays.binarySearch(array, 4);
        System.out.println(i);
    }
}
