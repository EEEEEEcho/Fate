package com.labuladong.chapter1.elementdel;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        //快慢指针
        int slow = 0;
        int fast = 0;
        while (fast < nums.length){
            if (nums[fast] != nums[slow]){
                slow ++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }
}
