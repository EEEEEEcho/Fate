package com.code.carl.array.binarysearch;
//34. 在排序数组中查找元素的第一个和最后一个位置
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = searchLeft(nums,target);
        result[1] = searchRight(nums,target);
        return result;
    }
    public int searchLeft(int[] nums,int target){
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                //不能返回，继续向左挤压，锁定左侧边界
                right = mid - 1;
            }
            else if (nums[mid] > target){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        //为了防止目标值过大，超过了数组长度
        if(left >= nums.length || nums[left] != target) return -1;
        //左侧搜寻当然要返回左侧
        return left;
    }

    public int searchRight(int[] nums,int target){
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                //向右挤压右边界
                left = mid + 1;
            }
            else if(nums[mid] > target){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        //为了防止目标过小越界
        if(right < 0 || nums[right] != target) return -1;
        //右侧搜索当然返回右边界
        return right;
    }
}
