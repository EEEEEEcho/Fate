package com.code.Dynamic;

import java.util.Arrays;

public class MaxProduct {
    //因为有整数、负数和0的存在，所以前面子数组的最大乘积如果乘一个负数，那么就变成了最小值
    //如果前面子数组的最小值乘一个负数，就成了最大值，所以需要维护一个最小值，然后分别用前子数组的
    //最大值或者最小值来与当前数组的值进行乘积运算，再判断大小
    public int maxProduct(int[] nums) {
        int length = nums.length;
        int[] dpMax = new int[length];
        int[] dpMin = new int[length];
        System.arraycopy(nums,0,dpMax,0,length);
        System.arraycopy(nums,0,dpMin,0,length);
        for (int i = 1; i < length; i++) {
            dpMax[i] = Math.max(dpMax[i - 1] * nums[i],Math.max(nums[i],dpMin[i - 1] * nums[i]));
            dpMin[i] = Math.min(dpMin[i - 1] * nums[i],Math.min(nums[i],dpMax[i - 1] * nums[i]));
        }
        return Arrays.stream(dpMax).max().getAsInt();
    }
    //空间优化
    public int maxProduct1(int[] nums) {
        int length = nums.length;
        int min = nums[0];
        int max = nums[0];
        int ans = nums[0];
        for (int i = 1; i < length; i++) {
            //为了防止max发生变化后影响min
            int mx = max;
            int mn = min;
            max = Math.max(mx * nums[i],Math.max(nums[i], mn * nums[i]));
            min = Math.min(mn * nums[i],Math.min(nums[i],mx * nums[i]));
            ans = Math.max(max,ans);
        }
        return ans;
    }
}
