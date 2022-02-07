package com.code.Dynamic;

import java.util.Arrays;

public class MaxSubarraySumCircular {


    public int maxSubarraySumCircular(int[] nums){
        //两种情况：一种是最大子序和出现在数组中间。另一种是最大子序和出现在数组的两端
        //第一种情况正常使用Kadane算法计算就好
        //第二种情况使用Kadane算法计算出最小子序和，然后用数组总和减去最小子序和就是最大子序和
        int preMax = 0;
        int preMin = 0;
        int ansMax = nums[0];
        int ansMin = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            preMax = Math.max(preMax + nums[i],nums[i]);
            ansMax = Math.max(preMax,ansMax);

            preMin = Math.min(preMin + nums[i],nums[i]);
            ansMin = Math.min(preMin,ansMin);
            sum += nums[i];
        }
        //全是负数
        if (ansMax < 0){
            return ansMax;
        }
        return Math.max(ansMax,sum - ansMin);

    }

    //没通过。。。
    public int maxSubarraySumCircularLosser(int[] nums) {
        int pre = 0;
        int ans = nums[0];
        int n = nums.length;
        boolean[] mark = new boolean[n];
        int i = 0;
        while (true){
            if (mark[i % n]){
                break;
            }
            else{
                if (nums[i % n] + pre >= nums[i % n]){
                    mark[i % n] = true;
                    pre = pre + nums[i % n];
                }
                else{
                    pre = nums[i % n];
                    //Arrays.fill(mark,false);
                }
                ans = Math.max(pre,ans);
            }
            i ++;
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxSubarraySumCircular m = new MaxSubarraySumCircular();
        int i = m.maxSubarraySumCircular(new int[]{5,-3,5});
        System.out.println(i);
    }
}
