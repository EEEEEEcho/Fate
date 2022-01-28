package com.code.topOnehundred;

import java.util.Arrays;

public class FindDuplicate {
    //没有符合题意
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) return nums[i];
        }
        return 0;
    }
    //快慢指针的解法,真的秀
    //https://leetcode-cn.com/problems/find-the-duplicate-number/solution/287xun-zhao-zhong-fu-shu-by-kirsche/
    public int findDuplicate2(int[] nums){
        int slow = 0;
        int fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        //找到环起点
        while (slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        //从头出发，重新相遇的地方就是重复数字
        int pre = 0;
        int pre2 = slow;
        while (pre != pre2){
            pre = nums[pre];
            pre2 = nums[pre2];
        }
        return pre;
    }

    //二分查找，利用抽屉原理，这个也很秀
    //https://leetcode-cn.com/problems/find-the-duplicate-number/solution/er-fen-fa-si-lu-ji-dai-ma-python-by-liweiwei1419/
    public int findDuplicate3(int[] nums){
        int left = 1;
        int right = nums.length - 1;
        while (left < right){
            int mid = left + (right - left) / 2;

            int count = 0;
            for (int num : nums){
                if(num <= mid) count ++;
            }
            //如果统计出来的<=mid的数字的个数，比mid还大，那么重复肯定发生在左边
            if (count > mid){
                right = mid;
            }
            else {
                //否则，就是在右边
                left = mid + 1;
            }
        }
        //这里 left和right都是对的
        return left;
    }

    public static void main(String[] args) {
        System.out.println(1 ^ 2 ^ 3);
    }
}
