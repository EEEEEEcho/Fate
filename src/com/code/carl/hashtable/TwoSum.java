package com.code.carl.hashtable;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])){
                ans[0] = i;
                ans[1] = hashMap.get(target - nums[i]);
                return ans;
            }
            else{
                hashMap.put(nums[i],i);
            }
        }
        return ans;
    }


    //双指针不适用于这种情况，这个题目求的是下标
    public int[] twoSum1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        Arrays.sort(nums);
        int[] res = new int[2];
        while (left < right){
            int nowSum = nums[left] + nums[right];
            if (nowSum == target){
                res[0] = left;
                res[1] = right;
                return res;
            }
            else if (nowSum < target){
                //必须这么写，才能让left和left + 1不相等时也能让left + 1,从而避免死循环
                while (left < right && nums[left] == nums[++left]);
            }
            else {
                while (left < right && nums[right] == nums[--right]);
            }
        }
        return res;
    }

}
