package com.code.topOnehundred;

import java.util.*;

public class ThreeSum {

    /**
     * 总体思路，固定最左边的数，从最左边的 + 1开始和最后一个元素双指针查，
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums){
        if (nums == null || nums.length < 3){
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        //到num.length - 2是为了保证，固定好左边的数之后，右边还有两个元素可以选
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break; //后续元素肯定都大于0
            if (i > 0 && nums[i] == nums[i - 1]) continue;  //去重
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0){
                    //右边的太大了
                    //去除所有的重复元素
                    while (left < right && nums[right] == nums[--right]);
                }
                else if(sum < 0){
                    //左边的太小了
                    //去重
                    while (left < right && nums[left] == nums[++left]);
                }
                else{
                    ans.add(new ArrayList<>(Arrays.asList(nums[i],nums[left],nums[right])));
                    //除了这两个数之外，可能还有另外两个数可以与当前的nums[i] 构成0
                    //去重
                    while (left < right && nums[left] == nums[++left]);
                    while (left < right && nums[right] == nums[--right]);
                }
            }
        }
        return ans;
    }

    /**
     *  回溯能做，但是超时
     *
     */

    private Set<List<Integer>> ans = new HashSet<>();
    public List<List<Integer>> threeSum1(int[] nums) {
        if (nums == null || nums.length < 3){
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        backtrace(nums,new ArrayDeque<>(),0);
        return new ArrayList<List<Integer>>(ans);
    }
    public void backtrace(int[] nums, ArrayDeque<Integer> path, int index){
        if (path.size() == 3){
            if (path.stream().mapToInt(i -> i).sum() == 0){
                ans.add(new ArrayList<>(path));
            }
            return;
        }
        else{
            for (int i = index; i < nums.length; i++) {
                int nowSum = path.stream().mapToInt(n -> n).sum();
                if (nowSum > 0) break;
                path.add(nums[i]);
                backtrace(nums,path,i + 1);
                path.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> lists = threeSum.threeSum(new int[]{-1,1,2,-2});
        System.out.println(lists);
    }
}
