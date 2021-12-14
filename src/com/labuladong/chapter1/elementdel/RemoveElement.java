package com.labuladong.chapter1.elementdel;

public class RemoveElement {
    //快慢指针
    public int removeElement(int[] nums, int val) {
        int fast = 0;
        int slow = 0;
        while (fast < nums.length){
            if (nums[fast] != val){
                nums[slow] = nums[fast];
                slow ++;
            }
            fast++;
        }
        return slow;
    }
}
