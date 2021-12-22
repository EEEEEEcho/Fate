package com.labuladong.chapter1.binarysearch;

import java.util.Arrays;

public class Search {
    public int search(int[] nums, int target) {
        //最简版本
//        int result = Arrays.binarySearch(nums, target);
//        return result >= 0 ? result : -1;
        //手写版本
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = (left + (right - left)) / 2;
            if(target == nums[mid]){
                return mid;
            }
            else if(target > nums[mid]){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return -1;
    }

    //[1,2,2,2,3]   中间搜索，搜索到的下标为2
    public int midSearch(int[] nums,int target){
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target){
                left = mid + 1;
            }
            else if(nums[mid] > target){
                right = mid - 1;
            }
        }
        return -1;
    }

    //[1,2,2,2,3] 左限搜索，搜索到的下标为1
    public int leftSearch(int[] nums,int target){
        if(nums.length == 0) return -1;
        int left = 0;
        int right = nums.length;    //注意

        while (left < right){   //注意
            int mid = left + (right - left) / 2;
            //一直向左找
            //找到 target 时不要⽴即返回，⽽是缩⼩「搜索区间」的上界 right，
            // 在区间 [left, mid) 中继续搜索，即不断向左收缩，达到锁定左侧边界的⽬的
            if(nums[mid] == target){
                right = mid;
            }
            else if(nums[mid] < target){
                left = mid + 1;
            }
            else if(nums[mid] > target){
                right = mid;
            }
        }
        return left;
    }

    int leftSearch2(int[] nums,int target){
        if(nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            }
            else if(nums[mid] > target){
                right = mid - 1;
            }
            else if(nums[mid] == target){
                right = mid - 1;    //不断缩小右侧区域
            }
        }
        //越界检测
        if(left >= nums.length || nums[left] != target){
            return -1;
        }
        return left;
    }

    //[1,2,2,2,3] 右限搜索，搜索到的下标为3
    int rightSearch(int[] nums,int target){
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                left = mid + 1; //不断向右找
            }
            else if(nums[mid] < target){
                left = mid + 1;
            }
            else if(nums[mid] > target) {
                right = mid;
            }
        }
        if (left == 0) return -1;
        return nums[left - 1] == target ? (left - 1) : -1;
    }

    int rightSearch2(int[] nums,int target){
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] < target){
                left = mid + 1;
            }
            else if(nums[mid] > target){
                right = mid - 1;
            }
            else if(nums[mid] == target){
                left = mid + 1; //不断向右找
            }
        }
        if (right < 0 || nums[right] != target) return -1;
        return right;
    }

    public static void main(String[] args) {
        Search s = new Search();
        s.leftSearch(new int[]{1,2,2,2,3},2);
    }
}
