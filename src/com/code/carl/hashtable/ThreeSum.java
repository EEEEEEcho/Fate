package com.code.carl.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) return ans;
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int l = nums[left];
            int t = 0 - l;
            List<List<Integer>> twoSum = twoSum(nums, left + 1, t);
            if (!twoSum.isEmpty()){
                for (List<Integer> list : twoSum){
                    list.add(l);
                    ans.add(list);
                }
            }
            while (left < right && nums[left] == l) left ++;
        }
        return ans;
    }

    public List<List<Integer>> twoSum(int[] nums,int start,int target){
        //1.定义结果保存集
        List<List<Integer>> ans = new ArrayList<>();
        //2.限定条件
        if (nums == null || nums.length < 2 || start >= nums.length){
            return ans;
        }
        int left = start;
        int right = nums.length - 1;
        while (left < right){
            int l = nums[left];
            int r = nums[right];
            int t = l + r;
            if (target > t){
                while (left < right && nums[left] == l) left ++;
                if (left == right) break;
            }
            else if(target < t){
                while (left < right && nums[right] == r) right --;
                if (left == right) break;
            }
            else {
                ans.add(new ArrayList<>(Arrays.asList(l,r)));
                while (left < right && nums[left] == l) left ++;
                while (left < right && nums[right] == r) right --;
            }
        }
        return ans;
    }
}
