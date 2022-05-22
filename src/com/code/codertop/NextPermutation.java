package com.code.codertop;

import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        for (int i = nums.length - 1; i > 0; i--) {
            //从后向前找到第一个升序序列
            if (nums[i - 1] < nums[i]){
                //接下来找到比nums[j]大的最小的数字

                //从 i 到最后的数组进行排序
                Arrays.sort(nums,i,nums.length);
                //从排序后i的位置开始向后找第一个大于j的元素
                for (int k = i; k < nums.length; k++) {
                    if (nums[k] > nums[i - 1]){
                        int tmp = nums[i - 1];
                        nums[i - 1] = nums[k];
                        nums[k] = tmp;
                        return;
                    }
                }
            }
        }
        Arrays.sort(nums);
    }
}
