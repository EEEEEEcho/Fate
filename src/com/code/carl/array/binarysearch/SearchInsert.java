package com.code.carl.array.binarysearch;
//35. 搜索插入位置
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        //因为left和right会出现相等的情况。在边界的时候也会出现相等的情况。
        //只要是找不到，那么肯定就会出现right在left的左边，left在right的右边情况
        //比如left = 0 right = -1   left = 1 right = 0;
        //所以，right + 1就是插入的位置
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }
            else if(target > nums[mid]){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return right + 1;
    }
}
