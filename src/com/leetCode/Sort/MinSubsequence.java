package com.leetCode.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinSubsequence {
    /**
     * 未解决，有点难
     * @param nums
     * @return
     */
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> results = new ArrayList<>();
        int i = 0;
        int j = nums.length - 1;
        int sum1 = 0;
        int sum2 = 0;
        while (i < j){
            ArrayList<Integer> arrayList = new ArrayList<>();
            sum1 += nums[i];
            sum2 += nums[j];
            arrayList.add(sum2);
            if(sum1 >= sum2){
                results.add(arrayList);
            }
            i++;
            j--;
        }
        if(results.size() == 1){
            return results.get(0);
        }
//        else {
//            for(int k = 0;k < results.size() - 1;k ++){
//                if(results.get(k).size() == results.get())
//            }
//        }
        return null;
    }
}
