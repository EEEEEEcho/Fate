package com.labuladong.chapter5.nsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return nSum(nums,4,0,target);
    }
    //定义一个解决通用Nsum问题的函数
    public List<List<Integer>> nSum(int[] nums,int sum,int start,int target){
        int N = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        if (N < sum || sum < 2) return ans;
        if (sum == 2){
            //如果是twoSum,执行twoSum那一套
            int low = start;
            int high = N - 1;
            while (low < high){
                int left = nums[low];
                int right = nums[high];
                int t = left + right;
                if (t > target){
                    while (low < high && nums[high] == right) high --;
                }
                else if(t < target){
                    while (low < high && nums[low] == left) low ++;
                }
                else{
                    ans.add(new ArrayList<>(Arrays.asList(left,right)));
                    while (low < high && nums[high] == right) high --;
                    while (low < high && nums[low] == left) left ++;
                }
            }
        }
        else{
            int left = start;
            while (left < nums.length){
                int t = nums[left];
                int anotherTag = target - t;
                List<List<Integer>> lists = nSum(nums, sum - 1, left + 1, anotherTag);
                if (!lists.isEmpty()){
                    for (List<Integer> list : lists) {
                        List<Integer> tmp = new ArrayList<>(list);
                        tmp.add(t);
                        ans.add(tmp);
                    }
                }
                while (left < nums.length && nums[left] == t) left ++;
            }
        }
        return ans;
    }
}
