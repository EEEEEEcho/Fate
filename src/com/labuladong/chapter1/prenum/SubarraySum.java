package com.labuladong.chapter1.prenum;

import java.util.HashMap;

public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int[] preNums = new int[nums.length + 1];
        for (int i = 1; i < preNums.length; i++) {
            preNums[i] =  preNums[i - 1] + nums[i - 1];
        }
        //穷举所有子数组的和看看哪个和与目标相同
        for (int i = 1; i < preNums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (preNums[i] - preNums[j] == k){
                    count ++;
                }
            }
        }
        return count;
    }

    //哈希表前缀和，效率更高
    public int subarraySum2(int[] nums,int k){
        HashMap<Integer,Integer> preNums = new HashMap<>();
        preNums.put(0,1);
        int sum_i = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum_i += nums[i];
            if(preNums.containsKey(sum_i - k)){
                //sum[i] - sum[j] = k;
                //如果前面的前缀和中有
                count += preNums.get(sum_i - k);

            }
            preNums.put(sum_i,preNums.getOrDefault(sum_i,0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        SubarraySum subarraySum = new SubarraySum();
        int i = subarraySum.subarraySum(new int[]{1}, 1);
        System.out.println(i);
    }
}
