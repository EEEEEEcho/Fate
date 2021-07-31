package com.code.ArrayTrain;

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
        if(nums.length == 1){
           return nums;
        }
        int i = 0;
        int j = nums.length - 1;
        while (i < j){
            while (i < nums.length && nums[i] % 2 == 0) i++;
            while (j > 0 && nums[j] % 2 != 0) j--;
            if (i > nums.length - 1 || j < 0 || i > j){
                break;
            }
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
        return nums;
    }
}
