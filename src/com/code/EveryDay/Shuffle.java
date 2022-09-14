package com.code.EveryDay;

public class Shuffle {
    public int[] shuffle(int[] nums, int n) {
        if (nums.length <= 2) return nums;
        int[] ans = new int[2 * n];
        int index = 0;
        int i = 0;
        int j = n;
        while (i < n){
            ans[index ++] = nums[i ++];
            ans[index ++] = nums[j ++];
        }
        return ans;
    }
}
