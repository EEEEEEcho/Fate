package com.code.carl.array.removenum;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        int fast = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[fast] != val){
                nums[slow ++] = nums[fast];
            }
            fast ++;
        }
        return slow;
    }
}
