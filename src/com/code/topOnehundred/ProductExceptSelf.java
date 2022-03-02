package com.code.topOnehundred;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length <= 1){
            return nums;
        }
        int n = nums.length;
        int[] prefix = new int[n];
        int[] shufix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i];
        }
        shufix[n - 1] = nums[n - 1];
        for (int i = n - 2;i >= 0;i --){
            shufix[i] = shufix[i + 1] * nums[i];
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int s = i - 1 >= 0 ? prefix[i - 1] : 1;
            int e = i + 1 < n ? shufix[i + 1] : 1;
            ans[i] = s * e;
        }
        return ans;
    }
    //空间优化,错位法
    public int[] productExceptSelf2(int[] nums) {
        if (nums == null || nums.length <= 1){
            return nums;
        }
        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        int r = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = ans[i] * r;
            r = r * nums[i];
        }
        return ans;
    }
}
