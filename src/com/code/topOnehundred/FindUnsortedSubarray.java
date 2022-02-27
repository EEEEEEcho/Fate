package com.code.topOnehundred;

import java.util.Arrays;

public class FindUnsortedSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int start = 0;
        int end = 0;
        int[] source = new int[nums.length];
        System.arraycopy(nums,0,source,0,nums.length);
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != source[i]){
                start = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != source[i]){
                end = i;
                break;
            }
        }
        if (start < end){
            return end - start + 1;
        }
        else{
            return 0;
        }
    }
    public int findUnsortedSubarray1(int[] nums){
        //数组分为三段 numsA,numsB,numsC
        //numsA为有序递增的，且numsA中所有的数都小于numsB
        //numsC为有序递增的，且numsC中所有的数都大于numsB
        //所需要求的是numsB的边界。
        //从左到右维护一个最大值max,在进入右段之前，那么遍历到的nums[i]都是小于max的，我们要求的end就是遍历中最后一个小于max元素的位置
        //同理，从右到左维护一个最小值min，在进入左段之前，那么遍历到的nums[i]也都是大于min的，要求的begin也就是最后一个大于min元素的位置。
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int right = -1;
        int min = Integer.MAX_VALUE;
        int left = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= max){
                max = nums[i];
            }
            else{
                right = i;
            }

            if (nums[n - i - 1] <= min){
                min = nums[n - i - 1];
            }
            else {
                left = n - i - 1;
            }
        }
        return right == -1? 0 : right - left + 1;
    }

    public static void main(String[] args) {
        FindUnsortedSubarray f = new FindUnsortedSubarray();
        f.findUnsortedSubarray1(new int[]{2,6,4,8,10,9,15});
    }
}
