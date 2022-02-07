package com.code.Dynamic;

import java.util.List;

public class CanJump2 {
    /**
     * 贪心，从后往前找，
     * 我们可以「贪心」地选择距离最后一个位置最远的那个位置，
     * 也就是对应下标最小的那个位置。因此，我们可以从左到右遍历数组，
     * 选择第一个满足要求的位置。
     * @param nums
     * @return
     */
    public int canJump1(int nums[]){
        int count = 0;
        int position = nums.length - 1;
        while (position > 0){
            for (int i = 0; i < position; i++) {
                if (nums[i] + i >= position){
                    count++;
                    position = i;
                    break;
                }
            }
        }
        return count;
    }
    public int canJump2(int nums[]){
        int max = 0;     //最远能跳的距离
        int end = 0;    //边界
        int step = 0;   //步数
        //因为肯定会跳到最后一个，所以这里不去考虑最后一个
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max,nums[i] + i);    //这里其实是在寻找边界，寻找最大能跳的距离。
            if (i == end){
                //如果到达了边界（也就是原来记录的一个最远的点）
                end = max;  //告诉下一个最远点的位置
                step ++;
            }
        }
        return step;
    }
}
