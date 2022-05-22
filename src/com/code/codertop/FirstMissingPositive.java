package com.code.codertop;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        /**
         * 那么我们如何将数组进行恢复呢？我们可以对数组进行一次遍历，对于遍历到的数 x = nums[i]，如果x∈[1,N]，
         * 我们就知道 xx 应当出现在数组中的 x - 1的位置，因此交换nums[i] 和nums[x−1]，这样x就出现在了正确的位置。

         */
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]){
                swap(nums,nums[i] - 1, i);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1){
                return i + 1;
            }
        }
        return nums.length + 1;
    }
    public void swap(int[]nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
