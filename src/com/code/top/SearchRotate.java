package com.code.top;

public class SearchRotate {
    public int searchRotate(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return nums[0] == target ? 0 : -1;
        int n = nums.length;
        if (target > nums[n - 1] && target < nums[0]) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[mid] >= nums[0]){
                if (target >= nums[0] && target <= nums[mid]){
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
            else{
                if (target >= nums[mid] && target <= nums[n - 1]){
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
