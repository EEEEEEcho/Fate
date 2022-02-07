package com.code.BitMultiplication;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElemen {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> hashMap = new HashMap<>();
        for(int num : nums){
            if(hashMap.get(num) == null){
                hashMap.put(num,1);
            }
            else{
                hashMap.put(num,hashMap.get(num) + 1);
            }
        }
        int max = 0;
        int key = 0;
        for(Map.Entry<Integer,Integer> entry : hashMap.entrySet()){
            if(entry.getValue() > max){
                max = entry.getValue();
                key = entry.getKey();
            }
        }
        return key;
    }
    public int majorityElement2(int[] nums) {
        /**
         * 排序法，因为一个数出现的次数超过了 len(nums) / 2,那么它一定会出现在中间位置
         */
        Arrays.sort(nums);
        return nums[nums.length >> 1];
    }
    /**
     * 摩尔投票法
     * 候选人(cand_num)初始化为nums[0]，票数count初始化为1。
     * 当遇到与cand_num相同的数，则票数count = count + 1，否则票数count = count - 1。
     * 当票数count为0时，更换候选人，并将票数count重置为1。
     * 遍历完数组后，cand_num即为最终答案。
     *
     * 为何这行得通呢？
     * 投票法是遇到相同的则票数 + 1，遇到不同的则票数 - 1。
     * 且“多数元素”的个数> ⌊ n/2 ⌋，其余元素的个数总和<= ⌊ n/2 ⌋。
     * 因此“多数元素”的个数 - 其余元素的个数总和 的结果 肯定 >= 1。
     * 这就相当于每个“多数元素”和其他元素 两两相互抵消，抵消到最后肯定还剩余至少1个“多数元素”。
     *
     * 无论数组是1 2 1 2 1，亦或是1 2 2 1 1，总能得到正确的候选人
     */
    public int majorityElement3(int[] nums) {
        if(nums.length <= 1){
            return nums[0];
        }
        int candiate = nums[0];
        int count = 1;
        for(int i = 1;i < nums.length;i ++){
            if(nums[i] != candiate){
                count --;
                if(count == 0){
                    candiate = nums[i];
                    count = 1;
                }
                continue;
            }
            count ++;
        }
        return candiate;
    }
}
