package com.code.EveryDay;

import java.util.Arrays;

public class SpecialArray {
    public int specialArray(int[] nums) {
        //[3,6,7,7,0]
        if (nums == null || nums.length == 0) return -1;
        int n = nums.length;
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j] >= i) count ++;
            }
            if (count == i) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        SpecialArray specialArray = new SpecialArray();
        int i = specialArray.specialArray(new int[]{3, 6, 7, 7, 0});
        System.out.println(i);
    }
}
