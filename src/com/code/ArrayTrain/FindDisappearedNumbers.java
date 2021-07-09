package com.code.ArrayTrain;

import java.util.*;

public class FindDisappearedNumbers {
    /**
     * 输入：nums = [4,3,2,7,8,2,3,1]
     * 输出：[5,6]
     * 最笨方法，两个集合求差集
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set1 = new HashSet<>();
        for (Integer num : nums){
            set1.add(num);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int i = 1;i <= nums.length;i ++){
            set2.add(i);
        }
        set2.removeAll(set1);
        return new ArrayList<>(set2);
    }

    public List<Integer> findDisappearedNumbers2(int[] nums) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        for (int i = 1;i <= nums.length;i ++){
            if(Arrays.binarySearch(nums,i) < 0){
                result.add(i);
            }
        }
        return result;
    }

    /**
     * 最强解法。
     * 时间复杂度O(n),空间复杂度(1)
     * 实际上就是把自己当作一个标记。
     * 数组中的数是1 ~ n , 而数组的下标是0 ~ n-1,由此可以产生联系
     * 如果一个数出现在过1 ~ n中，那么就将这个数对应的下标 num - 1 对应的数置为负数。做一个标记，最后遍历的时候，值
     * 不是负数的就是没有出现的
     * 这题用鸽笼原理实现，由题意可得，1~n的位置表示1~n个笼子，如果出现过，相应的“鸽笼”就会被占掉，我们将数字置为负
     * 数表示被占掉了。 最后再遍历一遍，如果“鸽笼”为正数就是没出现的数字。
     * 输入：nums = [4,3,2,7,8,2,3,1]
     * 输出：[5,6]
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers3(int[] nums) {
        for (Integer num : nums){
            //这里使用Math.abs(num)是因为前面的操作可能会把某个num改为负值
            nums[Math.abs(num) - 1] = -Math.abs(nums[Math.abs(num) - 1]);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0){
                list.add(i + 1);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Set<Integer> s1 = new HashSet<>();
        s1.add(1);
        s1.add(2);
        Set<Integer> s2 = new HashSet<>();
        s2.add(2);
        s2.add(3);
        s2.removeAll(s1);
        System.out.println(s2);
    }
}
