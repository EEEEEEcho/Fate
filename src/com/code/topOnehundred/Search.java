package com.code.topOnehundred;

import java.util.Arrays;

public class Search {
    public int search(int[] nums, int target){
        if (nums == null || nums.length == 0){
            return -1;
        }
        if (nums.length == 1){
            return nums[0] == target ? 0 : -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = (left + (right - left) / 2);
            if (nums[mid] == target){
                return mid;
            }
            if (nums[0] <= nums[mid]){
                //左边有序
                if (target >= nums[0] && target <= nums[mid]){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
            else{
                //右边有序
                if (target <= nums[nums.length - 1] && target >= nums[mid]){
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
    public int search1(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return -1;
        }
        int first = nums[0];
        int last = nums[nums.length - 1];
        if (first < last){
            int i = Arrays.binarySearch(nums, target);
            return i >= 0 ? i : -1;
        }
        else{
            if (target > last && target < first){
                return -1;
            }
            else if(target <= last){
                for (int i = nums.length - 1; i >=0 ; i--) {
                    if (target == nums[i]){
                        return i;
                    }
                    if (i > 0 && nums[i - 1] > nums[i]){
                        return -1;
                    }
                }
            }
            else {
                for (int i = 0; i < nums.length; i++) {
                    if (target == nums[i]){
                        return i;
                    }
                    if (i <= nums.length - 1 && nums[i + 1] < nums[i]){
                        return -1;
                    }
                }
            }
        }
        return -1;
    }


}
