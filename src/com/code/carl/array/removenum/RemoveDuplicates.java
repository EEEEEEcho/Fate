package com.code.carl.array.removenum;
//26. 删除有序数组中的重复项
// 注意，此题目给的是升序排列的数组，所以可以这样做
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[slow] != nums[fast]){
                //先递增，后赋值
                nums[++slow] = nums[fast];
            }
            fast ++;
        }
        return slow + 1;
    }
}
