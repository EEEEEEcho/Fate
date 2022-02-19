package com.code.topOnehundred;

import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (right > left && nums[right] < nums[right - 1]){
            right --;
        }

        if (right > left){
            int index = nums.length - 1;
            while (index >= right){
                if (nums[index] > nums[right - 1]){
                    break;
                }
                index --;
            }
            int tmp = nums[right - 1];
            nums[right - 1] = nums[index];
            nums[index] = tmp;
            sort(nums,right,nums.length - 1);
        }
        else {
            sort(nums,0,nums.length - 1);
        }
    }
    public void sort(int[] nums,int start,int end){
        for (int i = start; i <= end; i++) {
            int min = i;
            for (int j = i; j <= end; j++) {
                if (nums[j] < nums[min]){
                    min = j;
                }
            }
            int tmp = nums[i];
            nums[i] = nums[min];
            nums[min] = tmp;
        }
    }
    public static void main(String[] args) {
        NextPermutation n = new NextPermutation();
        n.nextPermutation(new int[]{1,3,2});
//        int[] test = new int[]{2,3,1};
//        n.sort(test,0,2);
//        System.out.println(Arrays.toString(test));
    }
}
