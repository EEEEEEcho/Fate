package com.code.topOnehundred;

public class SortColors {
    public void sortColors(int[] nums) {
        int p0 = 0;
        int p1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1){
                int tmp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = tmp;
                p1 ++;
            }
            else if(nums[i] == 0){
                int tmp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = tmp;
                if (p0 < p1){
                    int t = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = t;
                }
                p0 ++;
                p1 ++;
            }
        }
    }
    public void sortColors1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]){
                    minIndex = j;
                }
            }
            if (i != minIndex){
                int tmp = nums[minIndex];
                nums[minIndex] = nums[i];
                nums[i] = tmp;
            }
        }
    }

}
