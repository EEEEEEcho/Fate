package com.labuladong.chapter1.difference;

public class Difference {
    //拆分数组
    private final int[] diff;

    //输入原始数组，构造拆分数组
    public Difference(int[] nums){
        assert nums != null && nums.length > 0;
        diff = new int[nums.length];
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
    }
    //给定闭区间[i,j]增加val(可能是负数)
    public void increment(int i,int j,int value){
        diff[i] += value;
        if (j + 1 < diff.length) diff[j + 1] -= value;
    }
    //返回结果数组
    public int[] getResult(){
        int[] res = new int[diff.length];

        res[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            res[i] = diff[i] + res[i - 1];
        }
        return res;
    }
}
