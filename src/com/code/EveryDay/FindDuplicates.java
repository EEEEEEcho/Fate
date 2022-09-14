package com.code.EveryDay;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicates {
    //1.循环移位交换数字法
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) return ans;
        for (int i = 0; i < nums.length; i++) {
            while (i + 1 != nums[i] && nums[i] != nums[nums[i] - 1]){
                int index = nums[i] - 1;
                int tmp = nums[i];
                nums[i] = nums[index];
                nums[index] = tmp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1){
                ans.add(nums[i]);
            }
        }
        return ans;
    }
    //2.使用正负号作为标记

    /**
     * 我们也可以给nums[i] 加上「负号」表示数i+1已经出现过一次。具体地，我们首先对数组进行一次遍历。
     * 当遍历到位置i时，我们考虑nums[nums[i]−1]的正负性：
     * 如果nums[nums[i]−1]是正数，说明nums[i]还没有出现过，我们将nums[nums[i]−1]加上负号；
     * 如果nums[nums[i]−1]是负数，说明nums[i]已经出现过一次，我们将nums[i]放入答案。
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates2(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]);
            if (nums[index - 1] > 0){
                nums[index - 1] = - nums[index - 1];
            }
            else{
                list.add(index);
            }
        }
        return list;
    }
}
