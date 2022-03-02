package com.labuladong.chapter5.nsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//三数之和
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 3) return ans;
        int left = 0;
        int target = 0;
        while (left < nums.length){
            int t = nums[left];
            int anotherT = target - t;
            List<List<Integer>> twoSum = twoSum(nums, left + 1, nums.length, anotherT);
            if (!twoSum.isEmpty()){
                for (List<Integer> arr : twoSum){
                    List<Integer> tmp = new ArrayList<>(arr);
                    ans.add(tmp);
                }
            }
            while (left < nums.length && nums[left] == t){
                left ++;
            }
        }
        return ans;
    }

    //两数之和
    private List<List<Integer>> twoSum(int[] nums,int lo,int hi,int target){
        List<List<Integer>> ans = new ArrayList<>();
        //nums是有序的
        while (lo < hi){
            int left = nums[lo];
            int right = nums[hi];
            int num = left + right;
            if (num > target){
                while (lo < hi && nums[hi] == right) hi --;
            }
            else if(num < target){
                while (lo < hi && nums[lo] == left) lo ++;
            }
            else{
                ans.add(Arrays.asList(left,right));
                while (lo < hi && nums[hi] == right) hi--;
                while (lo < hi && nums[lo] == left) lo ++;
            }
        }
        return ans;
    }
}
