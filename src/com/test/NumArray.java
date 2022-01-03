package com.test;

import java.util.Arrays;

public class NumArray {
    //lowb解法
//    private final int[] nums;
//    public NumArray(int[] nums){
//        this.nums = nums;
//    }
//    public int sumRange(int left, int right) {
//        int sums = 0;
//        for (int i = left; i <= right ; i++) {
//            sums += nums[i];
//        }
//        return sums;
//    }
    //前缀和解法。说白了就是用一个数组，保存了从0到当前位置元素的和。
    private final int[] preSums;

    public NumArray(int nums[]){
        this.preSums = new int[nums.length + 1];
        preSums[0] = nums[0];
        for (int i = 1; i < preSums.length; i++) {
            preSums[i] = preSums[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left,int right){
        return preSums[right + 1] - preSums[left];
    }
}
