package com.code.ArrayTrain;

public class MoveZeros {
    /**
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 方法一：双指针
     * 使用双指针，左指针指向当前已经处理好的序列的尾部，右指针指向待处理序列的头部。
     * 右指针不断向右移动，每次右指针指向非零数，则将左右指针对应的数交换，同时左指针右移。
     * 注意到以下性质：
     * 左指针左边均为非零数；
     * 右指针左边直到左指针处均为零。
     * 因此每次交换，都是将左指针的零与右指针的非零数交换，且非零数的相对顺序并未改变。
     */
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        int n = nums.length;
        while (j < n){
            if (nums[j] != 0){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i ++;
            }
            j ++;
        }
    }

    /**
     * 覆盖法：既然都知道右边的都是0了，就用0覆盖后面的
     */
    public void moveZeroes2(int[] nums) {
        int i = 0;
        int j = 0;
        int n = nums.length;
        while (j < n){
            if (nums[j] != 0){
                nums[i] = nums[j];
                i ++;
            }
            j ++;
        }
        for (int k = i;k < n;k ++){
            nums[k] = 0;
        }
    }
}
