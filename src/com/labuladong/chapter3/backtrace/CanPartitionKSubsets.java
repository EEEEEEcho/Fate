package com.labuladong.chapter3.backtrace;

import java.util.Arrays;

public class CanPartitionKSubsets {
    /**
     * 我是脑残，不解释。
     * 将所有的数字，分成k份，要求结果都相同，那目标结果肯定就是 sum(nums) / k 啊
     * @param nums
     * @param k
     * @return
     */
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k > nums.length) return false;
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) return false;
        int target = sum / k;
        //倒叙排序数组，进行优化
        Arrays.sort(nums);
        int i = 0,j = nums.length - 1;
        while (i <= j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i ++;
            j --;
        }
        //创建k个桶，最后的目标是每个桶中的数组都相等为target
        int[] buckets = new int[k];
        //return backtrace(nums,buckets,0,target);
        return dfs(nums,new boolean[nums.length],target,k,0,0);
    }

    /**
     * 因为要判断是否能成功划分，而不是单纯的总结结果，所以需要返回bool值
     * 站在bucket的角度递归遍历nums
     * @return
     */
    public boolean backtrace(int[] nums,int[] buckets,int index,int target){
        //回溯结束条件
        if (index == nums.length){
            for (int i = 0; i < buckets.length; i++) {
                if (buckets[i] != target){
                    return false;
                }
            }
            return true;
        }
        for (int i = 0; i < buckets.length; i++) {
            //剪枝，这个桶里不需要这个数字
            if (buckets[i] + nums[index] > target){
                continue;
            }
            //做选择
            buckets[i] += nums[index];
            //递归，去判断nums中的下一个
            if (backtrace(nums,buckets,index + 1,target)){
                return true;
            }
            //回溯
            buckets[i] -= nums[index];
        }
        //nums[index]装到哪个桶里都不行
        return false;
    }

    /**
     *
     * @param nums 要遍历的数组
     * @param marked 标记数组，标记nums中的数字是否用过
     * @param target 目标结果
     * @param bucketIndex 当前第几个桶
     * @param bucketContent 当前桶中的内容
     * @param start 从nums[start]开始，向后选择
     * @return 是否达到目的
     */
    public boolean dfs(int[] nums,boolean[] marked,int target,int bucketIndex,int bucketContent,int start){
        if (bucketIndex == 0){
            //最后一个桶也装满了，装的是target，那么返回
            return true;
        }
        if (bucketContent == target){
            return dfs(nums,marked,target,bucketIndex - 1,0,0);
        }
        for (int i = start; i < nums.length; i++) {
            if (marked[i]) continue;        //用过了，继续循环
            if (bucketContent + nums[i] > target) continue;  //num[i]不合规，继续循环
            //做选择
            marked[i] = true;
            bucketContent += nums[i];
            if (dfs(nums,marked,target,bucketIndex,bucketContent,i)){
                return true;
            }
            //撤销选择
            marked[i] = false;
            bucketContent -= nums[i];
        }
        return false;
    }
}
