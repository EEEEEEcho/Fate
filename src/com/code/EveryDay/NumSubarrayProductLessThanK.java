package com.code.EveryDay;

public class NumSubarrayProductLessThanK {
    /*暴力，错误版本*/
    public int numSubarrayProductLessThanK1(int[] nums, int k) {
        int times = nums.length - 1;
        int count = 0;
        while (times >= 0) {
            for (int i = 0; i < nums.length; i++) {
                if (i + times < nums.length) {
                    int sum = 1;
                    for (int j = i; j <= i + times; j++) {
                        sum *= nums[j];
                    }
                    if (sum < k) count++;
                }
                else{
                    break;
                }
            }
            times--;
        }
        return count;
    }

    /*连续子数组，要考虑滑动窗口*/
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1) return 0;
        int left = 0;
        int right = 0;
        int mul = 1;

        int ans = 0;
        while (right < nums.length){
            mul *= nums[right];
            //我在这里扩大了right
            right ++;

            //收缩
            while (mul >= k){
                mul /= nums[left];
                left ++;
            }

            //每次右指针位移到一个新位置，应该加上 x 种数组组合：
            //  nums[right]
            //  nums[right-1], nums[right]
            //  nums[right-2], nums[right-1], nums[right]
            //  nums[left], ......, nums[right-2], nums[right-1], nums[right]
            ans += right - left;
        }
        return ans;
    }
    public static void main(String[] args) {
        NumSubarrayProductLessThanK thanK = new NumSubarrayProductLessThanK();
        int i = thanK.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6,}, 100);
        System.out.println(i);
    }
}
